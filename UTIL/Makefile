#******************************************************************************
# (C) 2015, Stefan Korner, Austria                                            *
#                                                                             *
# The Space Java Library is free software; you can redistribute it and/or     *
# modify it under the terms of the GNU Lesser General Public License as       *
# published by the Free Software Foundation; either version 2.1 of the        *
# License, or (at your option) any later version.                             *
#                                                                             *
# The Space Java Library is distributed in the hope that it will be useful,   *
# but WITHOUT ANY WARRANTY; without even the implied warranty of              *
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser     *
# General Public License for more details.                                    *
#******************************************************************************
# Makefile                                                                    *
#******************************************************************************

all: PKG_UTIL all_tst

clean:
	\rm -f *.class
	cd test; make clean

tst:
	cd test; make tst

PKG_UTIL: \
	DU.class

DU.class: DU.java
	cd ../..; javac SpaceJavaLibrary/UTIL/DU.java

all_tst:
	cd test; make
