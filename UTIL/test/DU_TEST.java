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
package SpaceJavaLibrary.UTIL.test;

import SpaceJavaLibrary.UTIL.DU;

public class DU_TEST
{
  // binary test data
  static final int[] DATA1 = {
    0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
    0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F,
    0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17,
    0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F,
    0x20, 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27,
    0x28, 0x29, 0x2A, 0x2B, 0x2C, 0x2D, 0x2E, 0x2F,
    0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37,
    0x38, 0x39, 0x3A, 0x3B, 0x3C, 0x3D, 0x3E, 0x3F,
    0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47,
    0x48, 0x49, 0x4A, 0x4B, 0x4C, 0x4D, 0x4E, 0x4F,
    0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x57,
    0x58, 0x59, 0x5A, 0x5B, 0x5C, 0x5D, 0x5E, 0x5F,
    0x60, 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67,
    0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
    0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77,
    0x78, 0x79, 0x7A, 0x7B, 0x7C, 0x7D, 0x7E, 0x7F,
    0x80, 0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87,
    0x88, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x8E, 0x8F,
    0x90, 0x91, 0x92, 0x93, 0x94, 0x95, 0x96, 0x97,
    0x98, 0x99, 0x9A, 0x9B, 0x9C, 0x9D, 0x9E, 0x9F,
    0xA0, 0xA1, 0xA2, 0xA3, 0xA4, 0xA5, 0xA6, 0xA7,
    0xA8, 0xA9, 0xAA, 0xAB, 0xAC, 0xAD, 0xAE, 0xAF,
    0xB0, 0xB1, 0xB2, 0xB3, 0xB4, 0xB5, 0xB6, 0xB7,
    0xB8, 0xB9, 0xBA, 0xBB, 0xBC, 0xBD, 0xBE, 0xBF,
    0xC0, 0xC1, 0xC2, 0xC3, 0xC4, 0xC5, 0xC6, 0xC7,
    0xC8, 0xC9, 0xCA, 0xCB, 0xCC, 0xCD, 0xCE, 0xCF,
    0xD0, 0xD1, 0xD2, 0xD3, 0xD4, 0xD5, 0xD6, 0xD7,
    0xD8, 0xD9, 0xDA, 0xDB, 0xDC, 0xDD, 0xDE, 0xDF,
    0xE0, 0xE1, 0xE2, 0xE3, 0xE4, 0xE5, 0xE6, 0xE7,
    0xE8, 0xE9, 0xEA, 0xEB, 0xEC, 0xED, 0xEE, 0xEF,
    0xF0, 0xF1, 0xF2, 0xF3, 0xF4, 0xF5, 0xF6, 0xF7,
    0xF8, 0xF9, 0xFA, 0xFB, 0xFC, 0xFD, 0xFE, 0xFF};
  static final int[] DATA2 = {0x00, 0x01, 0x02, 0x03, 0x44, 0x50, 0x6F, 0xFF};
  static final int[] DATA3 = {0x02, 0xFF, 0xFF};
  static final int[] DATA4 = {0x01, 0x02, 0x03, 0x04, 0x05};
  static final int[] DATA5 = {0x33, 0x55};
  // stingified test data
  static final String DATA1_STR = "\n" +
    "0000 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f ................\n" +
    "0010 10 11 12 13 14 15 16 17 18 19 1a 1b 1c 1d 1e 1f ................\n" +
    "0020 20 21 22 23 24 25 26 27 28 29 2a 2b 2c 2d 2e 2f  !\"#$%&'()*+,-./\n" +
    "0030 30 31 32 33 34 35 36 37 38 39 3a 3b 3c 3d 3e 3f 0123456789:;<=>?\n" +
    "0040 40 41 42 43 44 45 46 47 48 49 4a 4b 4c 4d 4e 4f @ABCDEFGHIJKLMNO\n" +
    "0050 50 51 52 53 54 55 56 57 58 59 5a 5b 5c 5d 5e 5f PQRSTUVWXYZ[\\]^_\n" +
    "0060 60 61 62 63 64 65 66 67 68 69 6a 6b 6c 6d 6e 6f `abcdefghijklmno\n" +
    "0070 70 71 72 73 74 75 76 77 78 79 7a 7b 7c 7d 7e 7f pqrstuvwxyz{|}~.\n" +
    "0080 80 81 82 83 84 85 86 87 88 89 8a 8b 8c 8d 8e 8f ................\n" +
    "0090 90 91 92 93 94 95 96 97 98 99 9a 9b 9c 9d 9e 9f ................\n" +
    "00a0 a0 a1 a2 a3 a4 a5 a6 a7 a8 a9 aa ab ac ad ae af ................\n" +
    "00b0 b0 b1 b2 b3 b4 b5 b6 b7 b8 b9 ba bb bc bd be bf ................\n" +
    "00c0 c0 c1 c2 c3 c4 c5 c6 c7 c8 c9 ca cb cc cd ce cf ................\n" +
    "00d0 d0 d1 d2 d3 d4 d5 d6 d7 d8 d9 da db dc dd de df ................\n" +
    "00e0 e0 e1 e2 e3 e4 e5 e6 e7 e8 e9 ea eb ec ed ee ef ................\n" +
    "00f0 f0 f1 f2 f3 f4 f5 f6 f7 f8 f9 fa fb fc fd fe ff ................";
  // for testing the accessor methods
  static final DU.BitAccessor BIT_FIELD1 = new DU.BitAccessor(48, 7);
  static final DU.ByteAccessor BYTE_FIELD1 = new  DU.ByteAccessor(6, 2);
  static final DU.IntAccessor INT_FIELD1 = new DU.IntAccessor(3, 2);

  //---------------------------------------------------------------------------
  static void TestAssert(boolean p_expression) throws Exception
  //---------------------------------------------------------------------------
  {
    if(!p_expression)
    {
      throw new Exception("TestAssert failed");
    }
  }

  //---------------------------------------------------------------------------
  static void testGetBits(DU p_du,
                          int p_bitPos,
                          int p_bitLength,
                          int p_value) throws Exception
  //---------------------------------------------------------------------------
  {
    int readValue = p_du.getBits(p_bitPos, p_bitLength);
    System.out.println("readValue = " + String.format("%08x", readValue));
    TestAssert(readValue == p_value);
  }

  //---------------------------------------------------------------------------
  static void testSetBits(DU p_du,
                          int p_bitPos,
                          int p_bitLength,
                          int p_value,
                          String p_expectedDump) throws Exception
  //---------------------------------------------------------------------------
  {
    p_du.setBits(p_bitPos, p_bitLength, p_value);
    String dumpResult = p_du.toString();
    System.out.println("du = " + dumpResult);
    TestAssert(dumpResult.equals(p_expectedDump));
  }

  //---------------------------------------------------------------------------
  static void testGetBitsException(DU p_du,
                                   int p_bitPos,
                                   int p_bitLength) throws Exception
  //---------------------------------------------------------------------------
  {
    boolean exRaised = false;
    try
    {
      exRaised = false;
      int dummy = p_du.getBits(p_bitPos, p_bitLength);
    }
    catch(Exception ex)
    {
      System.out.println("expected getBits Exception = " + ex);
      exRaised = true;
    }
    TestAssert(exRaised);
  }

  //---------------------------------------------------------------------------
  static void testSetBitsException(DU p_du,
                                   int p_bitPos,
                                   int p_bitLength,
                                   int p_value) throws Exception
  //---------------------------------------------------------------------------
  {
    boolean exRaised = false;
    try
    {
      exRaised = false;
      p_du.setBits(p_bitPos, p_bitLength, p_value);
    }
    catch(Exception ex)
    {
      System.out.println("expected setBits Exception = " + ex);
      exRaised = true;
    }
    TestAssert(exRaised);
  }

  //---------------------------------------------------------------------------
  static void testGetBytes(DU p_du,
                           int p_bytePos,
                           int p_byteLength,
                           byte[] p_bytes) throws Exception
  //---------------------------------------------------------------------------
  {
    byte[] readBytes = p_du.getBytes(p_bytePos, p_byteLength);
    System.out.println("readBytes = " + DU.byteArrayToString(readBytes));
    for(int i = 0; i < p_byteLength; i++)
    {
      TestAssert(readBytes[i] == p_bytes[i]);
    }
  }

  //---------------------------------------------------------------------------
  static void testSetBytes(DU p_du,
                           int p_bytePos,
                           int p_byteLength,
                           byte[] p_bytes,
                           String p_expectedDump) throws Exception
  //---------------------------------------------------------------------------
  {
    p_du.setBytes(p_bytePos, p_byteLength, p_bytes);
    String dumpResult = p_du.toString();
    System.out.println("du = " + dumpResult);
    TestAssert(dumpResult.equals(p_expectedDump));
  }

  //---------------------------------------------------------------------------
  static void testGetBytesException(DU p_du,
                                    int p_bytePos,
                                    int p_byteLength) throws Exception
  //---------------------------------------------------------------------------
  {
    boolean exRaised = false;
    try
    {
      exRaised = false;
      byte[] dummy = p_du.getBytes(p_bytePos, p_byteLength);
    }
    catch(Exception ex)
    {
      System.out.println("expected getBytes Exception = " + ex);
      exRaised = true;
    }
    TestAssert(exRaised);
  }

  //---------------------------------------------------------------------------
  static void testSetBytesException(DU p_du,
                                    int p_bytePos,
                                    int p_byteLength,
                                    byte[] p_bytes) throws Exception
  //---------------------------------------------------------------------------
  {
    boolean exRaised = false;
    try
    {
      exRaised = false;
      p_du.setBytes(p_bytePos, p_byteLength, p_bytes);
    }
    catch(Exception ex)
    {
      System.out.println("expected setBytes Exception = " + ex);
      exRaised = true;
    }
    TestAssert(exRaised);
  }

  //---------------------------------------------------------------------------
  static void testGetInt(DU p_du,
                         int p_bytePos,
                         int p_byteLength,
                         int p_value) throws Exception
  //---------------------------------------------------------------------------
  {
    int readValue = p_du.getInt(p_bytePos, p_byteLength);
    System.out.println("readValue = " + String.format("%08x", readValue));
    TestAssert(readValue == p_value);
  }

  //---------------------------------------------------------------------------
  static void testSetInt(DU p_du,
                         int p_bytePos,
                         int p_byteLength,
                         int p_value,
                         String p_expectedDump) throws Exception
  //---------------------------------------------------------------------------
  {
    p_du.setInt(p_bytePos, p_byteLength, p_value);
    String dumpResult = p_du.toString();
    System.out.println("du = " + dumpResult);
    TestAssert(dumpResult.equals(p_expectedDump));
  }

  //---------------------------------------------------------------------------
  static void testGetIntException(DU p_du,
                                  int p_bytePos,
                                  int p_byteLength) throws Exception
  //---------------------------------------------------------------------------
  {
    boolean exRaised = false;
    try
    {
      exRaised = false;
      int dummy = p_du.getInt(p_bytePos, p_byteLength);
    }
    catch(Exception ex)
    {
      System.out.println("expected getInt Exception = " + ex);
      exRaised = true;
    }
    TestAssert(exRaised);
  }

  //---------------------------------------------------------------------------
  static void testSetIntException(DU p_du,
                                  int p_bytePos,
                                  int p_byteLength,
                                  int p_value) throws Exception
  //---------------------------------------------------------------------------
  {
    boolean exRaised = false;
    try
    {
      exRaised = false;
      p_du.setInt(p_bytePos, p_byteLength, p_value);
    }
    catch(Exception ex)
    {
      System.out.println("expected setInt Exception = " + ex);
      exRaised = true;
    }
    TestAssert(exRaised);
  }

  //---------------------------------------------------------------------------
  public static void main(String[] args)
  //---------------------------------------------------------------------------
  {
    String dumpResult;
    try
    {
      // create data units
      // *** TEST ***
      DU du0 = new DU();
      dumpResult = du0.toString();
      System.out.println("du0 = " + dumpResult);
      TestAssert(dumpResult.equals("EMPTY"));
      // *** TEST ***
      DU du1 = new DU(DU.toByteArray(DATA1));
      dumpResult = du1.toString();
      System.out.println("du1 = " + dumpResult);
      TestAssert(dumpResult.equals(DATA1_STR));
      // *** TEST ***
      DU du2 = new DU(DU.toByteArray(DATA2));
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02 03 44 50 6f ff                         ....DPo."));
      // *** TEST ***
      du2.resize(3);
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02                                        ..."));
      // *** TEST ***
      du2.resize(8);
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02 00 00 00 00 00                         ........"));
      // *** TEST ***
      du2.append(DU.toByteArray(DATA4));
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02 00 00 00 00 00 01 02 03 04 05          ............."));
      // *** TEST ***
      du2.clear();
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("EMPTY"));
      // *** TEST ***
      du2.init(DU.toByteArray(DATA2));
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02 03 44 50 6f ff                         ....DPo."));

      // test bit field read access
      testGetBits(du2, 48, 1, 0x00000000);
      testGetBits(du2, 48, 2, 0x00000001);
      testGetBits(du2, 48, 3, 0x00000003);
      testGetBits(du2, 48, 4, 0x00000006);
      testGetBits(du2, 48, 5, 0x0000000D);
      testGetBits(du2, 48, 6, 0x0000001B);
      testGetBits(du2, 48, 7, 0x00000037);
      testGetBits(du2, 48, 8, 0x0000006F);
      testGetBits(du2, 48, 16, 0x00006FFF);
      testGetBits(du2, 40, 24, 0x00506FFF);
      testGetBits(du2, 32, 32, 0x44506FFF);
      // test accessor for reading
      int intValue = du2.get(BIT_FIELD1);
      System.out.println("intValue = " + String.format("%08x", intValue));
      TestAssert(intValue == 0x00000037);
      // expected failures checking
      testGetBitsException(du0, 8, 8);
      testGetBitsException(du2, -1, 8);
      testGetBitsException(du2, 8, 0);
      testGetBitsException(du2, 8, 33);
      testGetBitsException(du2, 128, 8);

      // test bit field write access
      testSetBits(du2, 24, 32, 0x00000000, "\n" +
        "0000 00 01 02 00 00 00 00 ff                         ........");
      testSetBits(du2, 31, 1, 0x01, "\n" +
        "0000 00 01 02 01 00 00 00 ff                         ........");
      testSetBits(du2, 30, 2, 0x03, "\n" +
        "0000 00 01 02 03 00 00 00 ff                         ........");
      testSetBits(du2, 29, 3, 0x07, "\n" +
        "0000 00 01 02 07 00 00 00 ff                         ........");
      testSetBits(du2, 28, 4, 0x0F, "\n" +
        "0000 00 01 02 0f 00 00 00 ff                         ........");
      testSetBits(du2, 27, 5, 0x1F, "\n" +
        "0000 00 01 02 1f 00 00 00 ff                         ........");
      testSetBits(du2, 26, 6, 0x3F, "\n" +
        "0000 00 01 02 3f 00 00 00 ff                         ...?....");
      testSetBits(du2, 25, 7, 0x7F, "\n" +
        "0000 00 01 02 7f 00 00 00 ff                         ........");
      testSetBits(du2, 24, 8, 0xFF, "\n" +
        "0000 00 01 02 ff 00 00 00 ff                         ........");
      testSetBits(du2, 24, 32, 0x00000000, "\n" +
        "0000 00 01 02 00 00 00 00 ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFF80, "\n" +
        "0000 00 01 02 ff ff ff 80 ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFFC0, "\n" +
        "0000 00 01 02 ff ff ff c0 ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFFE0, "\n" +
        "0000 00 01 02 ff ff ff e0 ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFFF0, "\n" +
        "0000 00 01 02 ff ff ff f0 ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFFF8, "\n" +
        "0000 00 01 02 ff ff ff f8 ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFFFC, "\n" +
        "0000 00 01 02 ff ff ff fc ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFF7F, "\n" +
        "0000 00 01 02 ff ff ff 7f ff                         ........");
      testSetBits(du2, 24, 32, 0xFFFFFFFF, "\n" +
        "0000 00 01 02 ff ff ff ff ff                         ........");
      // test accessor for writing
      du2.set(BIT_FIELD1, 0x5C);
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02 ff ff ff b9 ff                         ........"));
      // expected failures checking
      testSetBitsException(du0, 8, 8, 0);
      testSetBitsException(du2, -1, 8, 0);
      testSetBitsException(du2, 8, 0, 0);
      testSetBitsException(du2, 8, 33, 0);
      testSetBitsException(du2, 0, 8, 0x00000100);
      testSetBitsException(du2, 128, 8, 1);

      // test byte field read access
      testGetBytes(du2, 2, 3, DU.toByteArray(DATA3));
      // test accessor for reading
      byte[] byteValue = du2.get(BYTE_FIELD1);
      System.out.println("byteValue = " + DU.byteArrayToString(byteValue));
      TestAssert((byteValue[0] == (byte) 0xB9) &&
                 (byteValue[1] == (byte) 0xFF));
      // expected failures checking
      testGetBytesException(du0, 1, 1);
      testGetBytesException(du2, -1, 1);
      testGetBytesException(du2, 1, 0);
      testGetBytesException(du2, 10, 1);

      // test byte field write access
      testSetBytes(du2, 1, 4, DU.toByteArray(DATA4), "\n" +
        "0000 00 01 02 03 04 ff b9 ff                         ........");
      // test accessor for writing
      du2.set(BYTE_FIELD1, DU.toByteArray(DATA5));
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 01 02 03 04 ff 33 55                         ......3U"));
      // expected failures checking
      testSetBytesException(du0, 1, 1, new byte[1]);
      testSetBytesException(du2, -1, 1, new byte[1]);
      testSetBytesException(du2, 1, 0, new byte[1]);
      testSetBytesException(du2, 1, 2, new byte[1]);
      testSetBytesException(du2, 0, 10, new byte[10]);

      // test integer field read access
      testGetInt(du2, 1, 1, 0x00000001);
      testGetInt(du2, 1, 2, 0x00000102);
      testGetInt(du2, 1, 3, 0x00010203);
      testGetInt(du2, 1, 4, 0x01020304);
      // test accessor for reading
      intValue = du2.get(INT_FIELD1);
      System.out.println("intValue = " + String.format("%08x", intValue));
      TestAssert(intValue == 0x00000304);
      // expected failures checking
      testGetIntException(du0, 1, 1);
      testGetIntException(du2, -1, 1);
      testGetIntException(du2, 1, 0);
      testGetIntException(du2, 1, 5);
      testGetIntException(du2, 10, 1);

      // test integer field write access
      testSetInt(du2, 1, 1, 0x000000F1, "\n" +
        "0000 00 f1 02 03 04 ff 33 55                         ......3U");
      testSetInt(du2, 1, 2, 0x0000F1F2, "\n" +
        "0000 00 f1 f2 03 04 ff 33 55                         ......3U");
      testSetInt(du2, 1, 3, 0x00F1F2F3, "\n" +
        "0000 00 f1 f2 f3 04 ff 33 55                         ......3U");
      testSetInt(du2, 1, 4, (int) 0xF1F2F3F4L, "\n" +
        "0000 00 f1 f2 f3 f4 ff 33 55                         ......3U");
      // test accessor for writing
      du2.set(INT_FIELD1, 0x00009876);
      dumpResult = du2.toString();
      System.out.println("du2 = " + dumpResult);
      TestAssert(dumpResult.equals("\n" +
        "0000 00 f1 f2 98 76 ff 33 55                         ....v.3U"));
      // expected failures checking
      testSetIntException(du0, 1, 1, 0);
      testSetIntException(du2, -1, 1, 0);
      testSetIntException(du2, 1, 0, 0);
      testSetIntException(du2, 1, 5, 0);
      testSetIntException(du2, 1, 1, 0x00000100);
      testSetIntException(du2, 1, 2, 0x00010000);
      testSetIntException(du2, 1, 3, 0x01000000);
      testSetIntException(du2, 10, 1, 0);

      // end of test
      System.out.println("*** test passed ***");
    }
    catch(Exception ex)
    {
      System.out.println("Exception = " + ex);
      System.out.println("*** test failed ***");
    }
  }
}
