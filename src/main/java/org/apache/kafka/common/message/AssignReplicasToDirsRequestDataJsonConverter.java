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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AssignReplicasToDirsRequestData.*;

public class AssignReplicasToDirsRequestDataJsonConverter {
    public static AssignReplicasToDirsRequestData read(JsonNode _node, short _version) {
        AssignReplicasToDirsRequestData _object = new AssignReplicasToDirsRequestData();
        JsonNode _brokerIdNode = _node.get("brokerId");
        if (_brokerIdNode == null) {
            throw new RuntimeException("AssignReplicasToDirsRequestData: unable to locate field 'brokerId', which is mandatory in version " + _version);
        } else {
            _object.brokerId = MessageUtil.jsonNodeToInt(_brokerIdNode, "AssignReplicasToDirsRequestData");
        }
        JsonNode _brokerEpochNode = _node.get("brokerEpoch");
        if (_brokerEpochNode == null) {
            throw new RuntimeException("AssignReplicasToDirsRequestData: unable to locate field 'brokerEpoch', which is mandatory in version " + _version);
        } else {
            _object.brokerEpoch = MessageUtil.jsonNodeToLong(_brokerEpochNode, "AssignReplicasToDirsRequestData");
        }
        JsonNode _directoriesNode = _node.get("directories");
        if (_directoriesNode == null) {
            throw new RuntimeException("AssignReplicasToDirsRequestData: unable to locate field 'directories', which is mandatory in version " + _version);
        } else {
            if (!_directoriesNode.isArray()) {
                throw new RuntimeException("AssignReplicasToDirsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DirectoryData> _collection = new ArrayList<DirectoryData>(_directoriesNode.size());
            _object.directories = _collection;
            for (JsonNode _element : _directoriesNode) {
                _collection.add(DirectoryDataJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AssignReplicasToDirsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("brokerId", new IntNode(_object.brokerId));
        _node.set("brokerEpoch", new LongNode(_object.brokerEpoch));
        ArrayNode _directoriesArray = new ArrayNode(JsonNodeFactory.instance);
        for (DirectoryData _element : _object.directories) {
            _directoriesArray.add(DirectoryDataJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("directories", _directoriesArray);
        return _node;
    }
    public static JsonNode write(AssignReplicasToDirsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DirectoryDataJsonConverter {
        public static DirectoryData read(JsonNode _node, short _version) {
            DirectoryData _object = new DirectoryData();
            JsonNode _idNode = _node.get("id");
            if (_idNode == null) {
                throw new RuntimeException("DirectoryData: unable to locate field 'id', which is mandatory in version " + _version);
            } else {
                if (!_idNode.isTextual()) {
                    throw new RuntimeException("DirectoryData expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.id = Uuid.fromString(_idNode.asText());
            }
            JsonNode _topicsNode = _node.get("topics");
            if (_topicsNode == null) {
                throw new RuntimeException("DirectoryData: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("DirectoryData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<TopicData> _collection = new ArrayList<TopicData>(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(TopicDataJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DirectoryData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("id", new TextNode(_object.id.toString()));
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (TopicData _element : _object.topics) {
                _topicsArray.add(TopicDataJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
            return _node;
        }
        public static JsonNode write(DirectoryData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class PartitionDataJsonConverter {
        public static PartitionData read(JsonNode _node, short _version) {
            PartitionData _object = new PartitionData();
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "PartitionData");
            }
            return _object;
        }
        public static JsonNode write(PartitionData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            return _node;
        }
        public static JsonNode write(PartitionData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TopicDataJsonConverter {
        public static TopicData read(JsonNode _node, short _version) {
            TopicData _object = new TopicData();
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                throw new RuntimeException("TopicData: unable to locate field 'topicId', which is mandatory in version " + _version);
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("TopicData expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("TopicData: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("TopicData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<PartitionData> _collection = new ArrayList<PartitionData>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(PartitionDataJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicId", new TextNode(_object.topicId.toString()));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (PartitionData _element : _object.partitions) {
                _partitionsArray.add(PartitionDataJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(TopicData _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
