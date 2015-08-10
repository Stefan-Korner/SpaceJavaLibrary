//*****************************************************************************
// (C) 2015, Stefan Korner, Austria                                           *
//                                                                            *
// The Space Java Library is free software; you can redistribute it and/or    *
// modify it under the terms of the GNU Lesser General Public License as      *
// published by the Free Software Foundation; either version 2.1 of the       *
// License, or (at your option) any later version.                            *
//                                                                            *
// The Space Java Library is distributed in the hope that it will be useful,  *
// but WITHOUT ANY WARRANTY; without even the implied warranty of             *
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser    *
// General Public License for more details.                                   *
//*****************************************************************************
// Utilities - Data Unit                                                      *
//*****************************************************************************
package SpaceJavaLibrary.UTIL;

//=============================================================================
public class DU
//-----------------------------------------------------------------------------
{

  // index = [firstBitInBytePos][lastBitInBytePos]
  static final byte[][] BIT_FILTER =
  {   
    {(byte) 0x7F, (byte) 0x3F, (byte) 0x1F, (byte) 0x0F, (byte) 0x07, (byte) 0x03, (byte) 0x01, 0x00},
    {          0, (byte) 0xBF, (byte) 0x9F, (byte) 0x8F, (byte) 0x87, (byte) 0x83, (byte) 0x81, (byte) 0x80},
    {          0,           0, (byte) 0xDF, (byte) 0xCF, (byte) 0xC7, (byte) 0xC3, (byte) 0xC1, (byte) 0xC0},
    {          0,           0,           0, (byte) 0xEF, (byte) 0xE7, (byte) 0xE3, (byte) 0xE1, (byte) 0xE0},
    {          0,           0,           0,           0, (byte) 0xF7, (byte) 0xF3, (byte) 0xF1, (byte) 0xF0},
    {          0,           0,           0,           0,           0, (byte) 0xFB, (byte) 0xF9, (byte) 0xF8},
    {          0,           0,           0,           0,           0,           0, (byte) 0xFD, (byte) 0xFC},
    {          0,           0,           0,           0,           0,           0,           0, (byte) 0xFE}
  };

  private byte[] m_buffer;

  //---------------------------------------------------------------------------
  public DU()
  //---------------------------------------------------------------------------
  {
    m_buffer = null;
  }

  //---------------------------------------------------------------------------
  public DU(byte[] p_buffer)
  //---------------------------------------------------------------------------
  {
    m_buffer = p_buffer;
  }

  //---------------------------------------------------------------------------
  public void clear()
  //---------------------------------------------------------------------------
  {
    m_buffer = null;
  }

  //---------------------------------------------------------------------------
  public byte[] buffer()
  //---------------------------------------------------------------------------
  {
    return m_buffer;
  }

  //---------------------------------------------------------------------------
  public int bufferSize()
  //---------------------------------------------------------------------------
  {
    if(m_buffer == null)
    {
      return 0;
    }
    return m_buffer.length;
  }

  //---------------------------------------------------------------------------
  // helper
  public String dumpStr()
  //---------------------------------------------------------------------------
  {
    int length = bufferSize();
    if(length == 0)
    {
      return "EMPTY";
    }
    byte[] dataBuffer = buffer();
    // display only the first 64K bytes
    if(length > 65536)
    {
      length = 65536;
    }
    String retVal = "";
    for(int i = 0; i < length; i += 16)
    {
      retVal += String.format("\n%04x ", i & 0xFFFF);
      String asciiData = "";
      int j = 0;
      for(; j < 16; j++)
      {
        int offset = i + j;
        if(offset >= length)
        {
          break;
        }
        byte nextByte = dataBuffer[offset];
        retVal += String.format("%02x ", nextByte);
        if((nextByte < 32) || (nextByte > 127))
        {
          asciiData +=  ".";
        }
        else
        {
          asciiData += (char) nextByte;
        }
      }
      // fillup the space if the line was incomplete
      for(; j < 16; j++)
      {
        retVal += "   ";
      }
      // append the ASCII representation of the line
      retVal += asciiData;
    }
    return retVal;
  }

  //---------------------------------------------------------------------------
  // extracts bits as numerical value
  // @return: The value 32 bit unsigned but mapped to 32 bit signed.
  public int getBits(int p_bitPos, int p_bitLength) throws Exception
  //---------------------------------------------------------------------------
  {
    // performance optimizations:
    // - divide by 8 is replaced by >> 3 (performance)
    // - modulo 8 is replaced by & 7 (performance)
    // note: the implementation is overcomplicated due to missing
    //       unsigned logic in Java
    // consistency checks
    if(p_bitLength == 0)
    {
      throw new Exception("invalid bitLength");
    }
    int lastBitPos = p_bitPos + p_bitLength - 1;
    int lastBytePos = lastBitPos >> 3;
    if(lastBytePos >= bufferSize())
    {
      throw new Exception("bitPos/bitLength out of buffer");
    }
    // accumulate the number starting with the first byte
    int bytePos = p_bitPos >> 3;
    long byteValue = (buffer()[bytePos] + 256) & 255;
    // first byte: filter the highest bits that do not belong to the value
    int firstBitInBytePos = p_bitPos & 7;
    long bitFilter = 1 << (8 - firstBitInBytePos);
    bitFilter -= 1;
    long value = byteValue & bitFilter;
    // next bytes...
    bytePos++;
    while(bytePos <= lastBytePos)
    {
      byteValue = (buffer()[bytePos] + 256) & 255;
      value = (value << 8) + byteValue;
      bytePos++;
    }
    // last byte: remove the lowest bits that do not belong to the value
    int lastBitInBytePos = lastBitPos & 7;
    value >>= 7 - lastBitInBytePos;
    return (int) value;
  }

  //---------------------------------------------------------------------------
  // sets bits as numerical unsigned value
  // @param p_value: The value is 32 bit unsigned but mapped to 32 bit signed.
  public void setBits(int p_bitPos,
                      int p_bitLength,
                      int p_value) throws Exception
  //---------------------------------------------------------------------------
  {
    // performance optimizations:
    // - divide by 8 is replaced by >> 3 (performance)
    // - modulo 8 is replaced by & 7 (performance)
    // note: the implementation is overcomplicated due to missing
    //       unsigned logic in Java
    // consistency checks
    if(m_buffer == null)
    {
      throw new Exception("DU is not initialize with a buffer");
    }
    if(p_bitLength == 0)
    {
      throw new Exception("invalid bitLength");
    }
    long value = (p_value + 0x100000000L) & 0xFFFFFFFFL;
    long maxValue = (1L << p_bitLength) - 1;
    if(value > maxValue)
    {
      throw new Exception("value out of range");
    }
    int lastBitPos = p_bitPos + p_bitLength - 1;
    int lastBytePos = lastBitPos >> 3;
    if(lastBytePos >= bufferSize())
    {
      throw new Exception("bitPos/bitLength out of buffer");
    }
    // set zero-bits in the buffer where the value aligns
    int firstBytePos = p_bitPos >> 3;
    int firstBitInBytePos = p_bitPos & 7;
    int lastBitInBytePos = lastBitPos & 7;
    int bytePos = firstBytePos;
    if(firstBytePos == lastBytePos)
    {
      m_buffer[bytePos] &= BIT_FILTER[firstBitInBytePos][lastBitInBytePos];
    }
    else
    {
      m_buffer[bytePos] &= BIT_FILTER[firstBitInBytePos][7];
      bytePos++;
      while(bytePos < lastBytePos)
      {
        m_buffer[bytePos] = 0;
        bytePos++;
      }
      m_buffer[bytePos] &= BIT_FILTER[0][lastBitInBytePos];
    }
    // fill value with trailing zero-bits to align with the position
    value <<= 7 - lastBitInBytePos;
    // decompose the value and add it to the buffer
    // starting at bytePos, which is at the last byte
    while(bytePos >= firstBytePos)
    {
      byte byteValue = (byte) (value & 0xFF);
      m_buffer[bytePos] |= byteValue;
      value >>= 8;
      if(bytePos == 0)
      {
        break;
      }
      bytePos--;
    }
  }

  //---------------------------------------------------------------------------
  // helper function to support testing
  public static byte[] toByteArray(int[] p_intArray)
  //---------------------------------------------------------------------------
  {
    int arraySize = p_intArray.length;
    byte[] byteArray = new byte[arraySize];
    for(int i = 0; i < arraySize; i++)
    {
      byteArray[i] = (byte) p_intArray[i];
    }
    return byteArray;
  }
}
