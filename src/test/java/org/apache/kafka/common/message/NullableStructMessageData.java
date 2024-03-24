/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class NullableStructMessageData implements ApiMessage {
    MyStruct nullableStruct;
    MyStruct2 nullableStruct2;
    MyStruct3 nullableStruct3;
    MyStruct4 nullableStruct4;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("nullable_struct", MyStruct.SCHEMA_0, ""),
            new Field("nullable_struct2", MyStruct2.SCHEMA_0, "")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("nullable_struct", MyStruct.SCHEMA_1, ""),
            new Field("nullable_struct2", MyStruct2.SCHEMA_1, ""),
            TaggedFieldsSection.of(
                0, new Field("nullable_struct3", MyStruct3.SCHEMA_1, ""),
                1, new Field("nullable_struct4", MyStruct4.SCHEMA_1, "")
            )
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 2;
    
    public NullableStructMessageData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public NullableStructMessageData() {
        this.nullableStruct = null;
        this.nullableStruct2 = new MyStruct2();
        this.nullableStruct3 = null;
        this.nullableStruct4 = new MyStruct4();
    }
    
    @Override
    public short apiKey() {
        return -1;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 2;
    }
    
    @Override
    public final void read(Readable _readable, short _version) {
        {
            if (_readable.readByte() < 0) {
                this.nullableStruct = null;
            } else {
                this.nullableStruct = new MyStruct(_readable, _version);
            }
        }
        {
            if (_version >= 1) {
                if (_readable.readByte() < 0) {
                    this.nullableStruct2 = null;
                } else {
                    this.nullableStruct2 = new MyStruct2(_readable, _version);
                }
            } else {
                this.nullableStruct2 = new MyStruct2(_readable, _version);
            }
        }
        {
            this.nullableStruct3 = null;
        }
        {
            this.nullableStruct4 = new MyStruct4();
        }
        this._unknownTaggedFields = null;
        if (_version >= 1) {
            int _numTaggedFields = _readable.readUnsignedVarint();
            for (int _i = 0; _i < _numTaggedFields; _i++) {
                int _tag = _readable.readUnsignedVarint();
                int _size = _readable.readUnsignedVarint();
                switch (_tag) {
                    case 0: {
                        if (_readable.readUnsignedVarint() <= 0) {
                            this.nullableStruct3 = null;
                        } else {
                            this.nullableStruct3 = new MyStruct3(_readable, _version);
                        }
                        break;
                    }
                    case 1: {
                        if (_readable.readUnsignedVarint() <= 0) {
                            this.nullableStruct4 = null;
                        } else {
                            this.nullableStruct4 = new MyStruct4(_readable, _version);
                        }
                        break;
                    }
                    default:
                        this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                        break;
                }
            }
        }
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (nullableStruct == null) {
            _writable.writeByte((byte) -1);
        } else {
            _writable.writeByte((byte) 1);
            nullableStruct.write(_writable, _cache, _version);
        }
        if (nullableStruct2 == null) {
            if (_version >= 1) {
                _writable.writeByte((byte) -1);
            } else {
                throw new NullPointerException();
            }
        } else {
            if (_version >= 1) {
                _writable.writeByte((byte) 1);
            }
            nullableStruct2.write(_writable, _cache, _version);
        }
        if (_version >= 1) {
            if (this.nullableStruct3 != null) {
                _numTaggedFields++;
            }
        } else {
            if (this.nullableStruct3 != null) {
                throw new UnsupportedVersionException("Attempted to write a non-default nullableStruct3 at version " + _version);
            }
        }
        if (_version >= 1) {
            if (this.nullableStruct4 == null || !this.nullableStruct4.equals(new MyStruct4())) {
                _numTaggedFields++;
            }
        } else {
            if (this.nullableStruct4 == null || !this.nullableStruct4.equals(new MyStruct4())) {
                throw new UnsupportedVersionException("Attempted to write a non-default nullableStruct4 at version " + _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 1) {
            _writable.writeUnsignedVarint(_numTaggedFields);
            if (nullableStruct3 != null) {
                _writable.writeUnsignedVarint(0);
                _writable.writeUnsignedVarint(this.nullableStruct3.size(_cache, _version) + 1);
                _writable.writeUnsignedVarint(1);
                nullableStruct3.write(_writable, _cache, _version);
            }
            if (nullableStruct4 == null) {
                _writable.writeUnsignedVarint(1);
                _writable.writeUnsignedVarint(1);
                _writable.writeUnsignedVarint(0);
            } else {
                if (!this.nullableStruct4.equals(new MyStruct4())) {
                    _writable.writeUnsignedVarint(1);
                    _writable.writeUnsignedVarint(this.nullableStruct4.size(_cache, _version) + 1);
                    _writable.writeUnsignedVarint(1);
                    nullableStruct4.write(_writable, _cache, _version);
                }
            }
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (nullableStruct == null) {
            if (_version >= 1) {
                _size.addBytes(1);
            } else {
                _size.addBytes(1);
            }
        } else {
            _size.addBytes(1);
            this.nullableStruct.addSize(_size, _cache, _version);
        }
        if (nullableStruct2 == null) {
            if (_version >= 1) {
                _size.addBytes(1);
            } else {
                _size.addBytes(1);
            }
        } else {
            if (_version >= 1) {
                _size.addBytes(1);
            }
            this.nullableStruct2.addSize(_size, _cache, _version);
        }
        if (_version >= 1) {
            if (nullableStruct3 == null) {
            } else {
                _numTaggedFields++;
                _size.addBytes(1);
                _size.addBytes(1);
                int _sizeBeforeStruct = _size.totalSize();
                this.nullableStruct3.addSize(_size, _cache, _version);
                int _structSize = _size.totalSize() - _sizeBeforeStruct;
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_structSize));
            }
        }
        if (_version >= 1) {
            if (nullableStruct4 == null) {
                _numTaggedFields++;
                _size.addBytes(1);
                _size.addBytes(1);
                _size.addBytes(1);
            } else {
                if (!this.nullableStruct4.equals(new MyStruct4())) {
                    _numTaggedFields++;
                    _size.addBytes(1);
                    _size.addBytes(1);
                    int _sizeBeforeStruct = _size.totalSize();
                    this.nullableStruct4.addSize(_size, _cache, _version);
                    int _structSize = _size.totalSize() - _sizeBeforeStruct;
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_structSize));
                }
            }
        }
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        if (_version >= 1) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NullableStructMessageData)) return false;
        NullableStructMessageData other = (NullableStructMessageData) obj;
        if (this.nullableStruct == null) {
            if (other.nullableStruct != null) return false;
        } else {
            if (!this.nullableStruct.equals(other.nullableStruct)) return false;
        }
        if (this.nullableStruct2 == null) {
            if (other.nullableStruct2 != null) return false;
        } else {
            if (!this.nullableStruct2.equals(other.nullableStruct2)) return false;
        }
        if (this.nullableStruct3 == null) {
            if (other.nullableStruct3 != null) return false;
        } else {
            if (!this.nullableStruct3.equals(other.nullableStruct3)) return false;
        }
        if (this.nullableStruct4 == null) {
            if (other.nullableStruct4 != null) return false;
        } else {
            if (!this.nullableStruct4.equals(other.nullableStruct4)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (nullableStruct == null ? 0 : nullableStruct.hashCode());
        hashCode = 31 * hashCode + (nullableStruct2 == null ? 0 : nullableStruct2.hashCode());
        hashCode = 31 * hashCode + (nullableStruct3 == null ? 0 : nullableStruct3.hashCode());
        hashCode = 31 * hashCode + (nullableStruct4 == null ? 0 : nullableStruct4.hashCode());
        return hashCode;
    }
    
    @Override
    public NullableStructMessageData duplicate() {
        NullableStructMessageData _duplicate = new NullableStructMessageData();
        if (nullableStruct == null) {
            _duplicate.nullableStruct = null;
        } else {
            _duplicate.nullableStruct = nullableStruct.duplicate();
        }
        if (nullableStruct2 == null) {
            _duplicate.nullableStruct2 = null;
        } else {
            _duplicate.nullableStruct2 = nullableStruct2.duplicate();
        }
        if (nullableStruct3 == null) {
            _duplicate.nullableStruct3 = null;
        } else {
            _duplicate.nullableStruct3 = nullableStruct3.duplicate();
        }
        if (nullableStruct4 == null) {
            _duplicate.nullableStruct4 = null;
        } else {
            _duplicate.nullableStruct4 = nullableStruct4.duplicate();
        }
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "NullableStructMessageData("
            + "nullableStruct=" + ((nullableStruct == null) ? "null" : nullableStruct.toString())
            + ", nullableStruct2=" + ((nullableStruct2 == null) ? "null" : nullableStruct2.toString())
            + ", nullableStruct3=" + ((nullableStruct3 == null) ? "null" : nullableStruct3.toString())
            + ", nullableStruct4=" + ((nullableStruct4 == null) ? "null" : nullableStruct4.toString())
            + ")";
    }
    
    public MyStruct nullableStruct() {
        return this.nullableStruct;
    }
    
    public MyStruct2 nullableStruct2() {
        return this.nullableStruct2;
    }
    
    public MyStruct3 nullableStruct3() {
        return this.nullableStruct3;
    }
    
    public MyStruct4 nullableStruct4() {
        return this.nullableStruct4;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public NullableStructMessageData setNullableStruct(MyStruct v) {
        this.nullableStruct = v;
        return this;
    }
    
    public NullableStructMessageData setNullableStruct2(MyStruct2 v) {
        this.nullableStruct2 = v;
        return this;
    }
    
    public NullableStructMessageData setNullableStruct3(MyStruct3 v) {
        this.nullableStruct3 = v;
        return this;
    }
    
    public NullableStructMessageData setNullableStruct4(MyStruct4 v) {
        this.nullableStruct4 = v;
        return this;
    }
    
    public static class MyStruct implements Message {
        String myString;
        int myInt;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("my_string", Type.STRING, ""),
                new Field("my_int", Type.INT32, "")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("my_string", Type.COMPACT_STRING, ""),
                new Field("my_int", Type.INT32, ""),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public MyStruct(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public MyStruct() {
            this.myString = "";
            this.myInt = 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public final void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of MyStruct");
            }
            {
                int length;
                if (_version >= 1) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field myString was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field myString had invalid length " + length);
                } else {
                    this.myString = _readable.readString(length);
                }
            }
            this.myInt = _readable.readInt();
            this._unknownTaggedFields = null;
            if (_version >= 1) {
                int _numTaggedFields = _readable.readUnsignedVarint();
                for (int _i = 0; _i < _numTaggedFields; _i++) {
                    int _tag = _readable.readUnsignedVarint();
                    int _size = _readable.readUnsignedVarint();
                    switch (_tag) {
                        default:
                            this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                            break;
                    }
                }
            }
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(myString);
                if (_version >= 1) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(myInt);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 1) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of MyStruct");
            }
            {
                byte[] _stringBytes = myString.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'myString' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(myString, _stringBytes);
                if (_version >= 1) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            _size.addBytes(4);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 1) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyStruct)) return false;
            MyStruct other = (MyStruct) obj;
            if (this.myString == null) {
                if (other.myString != null) return false;
            } else {
                if (!this.myString.equals(other.myString)) return false;
            }
            if (myInt != other.myInt) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (myString == null ? 0 : myString.hashCode());
            hashCode = 31 * hashCode + myInt;
            return hashCode;
        }
        
        @Override
        public MyStruct duplicate() {
            MyStruct _duplicate = new MyStruct();
            _duplicate.myString = myString;
            _duplicate.myInt = myInt;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "MyStruct("
                + "myString=" + ((myString == null) ? "null" : "'" + myString.toString() + "'")
                + ", myInt=" + myInt
                + ")";
        }
        
        public String myString() {
            return this.myString;
        }
        
        public int myInt() {
            return this.myInt;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public MyStruct setMyString(String v) {
            this.myString = v;
            return this;
        }
        
        public MyStruct setMyInt(int v) {
            this.myInt = v;
            return this;
        }
    }
    
    public static class MyStruct2 implements Message {
        String myString;
        int myInt;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("my_string", Type.STRING, ""),
                new Field("my_int", Type.INT32, "")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("my_string", Type.COMPACT_STRING, ""),
                new Field("my_int", Type.INT32, ""),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public MyStruct2(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public MyStruct2() {
            this.myString = "";
            this.myInt = 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public final void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of MyStruct2");
            }
            {
                int length;
                if (_version >= 1) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field myString was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field myString had invalid length " + length);
                } else {
                    this.myString = _readable.readString(length);
                }
            }
            this.myInt = _readable.readInt();
            this._unknownTaggedFields = null;
            if (_version >= 1) {
                int _numTaggedFields = _readable.readUnsignedVarint();
                for (int _i = 0; _i < _numTaggedFields; _i++) {
                    int _tag = _readable.readUnsignedVarint();
                    int _size = _readable.readUnsignedVarint();
                    switch (_tag) {
                        default:
                            this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                            break;
                    }
                }
            }
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(myString);
                if (_version >= 1) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(myInt);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 1) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of MyStruct2");
            }
            {
                byte[] _stringBytes = myString.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'myString' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(myString, _stringBytes);
                if (_version >= 1) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            _size.addBytes(4);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 1) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyStruct2)) return false;
            MyStruct2 other = (MyStruct2) obj;
            if (this.myString == null) {
                if (other.myString != null) return false;
            } else {
                if (!this.myString.equals(other.myString)) return false;
            }
            if (myInt != other.myInt) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (myString == null ? 0 : myString.hashCode());
            hashCode = 31 * hashCode + myInt;
            return hashCode;
        }
        
        @Override
        public MyStruct2 duplicate() {
            MyStruct2 _duplicate = new MyStruct2();
            _duplicate.myString = myString;
            _duplicate.myInt = myInt;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "MyStruct2("
                + "myString=" + ((myString == null) ? "null" : "'" + myString.toString() + "'")
                + ", myInt=" + myInt
                + ")";
        }
        
        public String myString() {
            return this.myString;
        }
        
        public int myInt() {
            return this.myInt;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public MyStruct2 setMyString(String v) {
            this.myString = v;
            return this;
        }
        
        public MyStruct2 setMyInt(int v) {
            this.myInt = v;
            return this;
        }
    }
    
    public static class MyStruct3 implements Message {
        String myString;
        int myInt;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("my_string", Type.COMPACT_STRING, ""),
                new Field("my_int", Type.INT32, ""),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 1;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public MyStruct3(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public MyStruct3() {
            this.myString = "";
            this.myInt = 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public final void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of MyStruct3");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field myString was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field myString had invalid length " + length);
                } else {
                    this.myString = _readable.readString(length);
                }
            }
            this.myInt = _readable.readInt();
            this._unknownTaggedFields = null;
            int _numTaggedFields = _readable.readUnsignedVarint();
            for (int _i = 0; _i < _numTaggedFields; _i++) {
                int _tag = _readable.readUnsignedVarint();
                int _size = _readable.readUnsignedVarint();
                switch (_tag) {
                    default:
                        this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                        break;
                }
            }
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of MyStruct3");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(myString);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(myInt);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of MyStruct3");
            }
            {
                byte[] _stringBytes = myString.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'myString' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(myString, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(4);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyStruct3)) return false;
            MyStruct3 other = (MyStruct3) obj;
            if (this.myString == null) {
                if (other.myString != null) return false;
            } else {
                if (!this.myString.equals(other.myString)) return false;
            }
            if (myInt != other.myInt) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (myString == null ? 0 : myString.hashCode());
            hashCode = 31 * hashCode + myInt;
            return hashCode;
        }
        
        @Override
        public MyStruct3 duplicate() {
            MyStruct3 _duplicate = new MyStruct3();
            _duplicate.myString = myString;
            _duplicate.myInt = myInt;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "MyStruct3("
                + "myString=" + ((myString == null) ? "null" : "'" + myString.toString() + "'")
                + ", myInt=" + myInt
                + ")";
        }
        
        public String myString() {
            return this.myString;
        }
        
        public int myInt() {
            return this.myInt;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public MyStruct3 setMyString(String v) {
            this.myString = v;
            return this;
        }
        
        public MyStruct3 setMyInt(int v) {
            this.myInt = v;
            return this;
        }
    }
    
    public static class MyStruct4 implements Message {
        String myString;
        int myInt;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("my_string", Type.COMPACT_STRING, ""),
                new Field("my_int", Type.INT32, ""),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 1;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public MyStruct4(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public MyStruct4() {
            this.myString = "";
            this.myInt = 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public final void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of MyStruct4");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field myString was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field myString had invalid length " + length);
                } else {
                    this.myString = _readable.readString(length);
                }
            }
            this.myInt = _readable.readInt();
            this._unknownTaggedFields = null;
            int _numTaggedFields = _readable.readUnsignedVarint();
            for (int _i = 0; _i < _numTaggedFields; _i++) {
                int _tag = _readable.readUnsignedVarint();
                int _size = _readable.readUnsignedVarint();
                switch (_tag) {
                    default:
                        this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                        break;
                }
            }
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of MyStruct4");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(myString);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(myInt);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of MyStruct4");
            }
            {
                byte[] _stringBytes = myString.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'myString' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(myString, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(4);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MyStruct4)) return false;
            MyStruct4 other = (MyStruct4) obj;
            if (this.myString == null) {
                if (other.myString != null) return false;
            } else {
                if (!this.myString.equals(other.myString)) return false;
            }
            if (myInt != other.myInt) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (myString == null ? 0 : myString.hashCode());
            hashCode = 31 * hashCode + myInt;
            return hashCode;
        }
        
        @Override
        public MyStruct4 duplicate() {
            MyStruct4 _duplicate = new MyStruct4();
            _duplicate.myString = myString;
            _duplicate.myInt = myInt;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "MyStruct4("
                + "myString=" + ((myString == null) ? "null" : "'" + myString.toString() + "'")
                + ", myInt=" + myInt
                + ")";
        }
        
        public String myString() {
            return this.myString;
        }
        
        public int myInt() {
            return this.myInt;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public MyStruct4 setMyString(String v) {
            this.myString = v;
            return this;
        }
        
        public MyStruct4 setMyInt(int v) {
            this.myInt = v;
            return this;
        }
    }
}
