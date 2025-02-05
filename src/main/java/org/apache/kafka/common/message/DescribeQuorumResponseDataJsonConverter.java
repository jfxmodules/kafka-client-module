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
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeQuorumResponseData.*;

public class DescribeQuorumResponseDataJsonConverter {
    public static DescribeQuorumResponseData read(JsonNode _node, short _version) {
        DescribeQuorumResponseData _object = new DescribeQuorumResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("DescribeQuorumResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeQuorumResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("DescribeQuorumResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("DescribeQuorumResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TopicData> _collection = new ArrayList<TopicData>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(TopicDataJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeQuorumResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (TopicData _element : _object.topics) {
            _topicsArray.add(TopicDataJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(DescribeQuorumResponseData _object, short _version) {
        return write(_object, _version, true);
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
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "PartitionData");
            }
            JsonNode _leaderIdNode = _node.get("leaderId");
            if (_leaderIdNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'leaderId', which is mandatory in version " + _version);
            } else {
                _object.leaderId = MessageUtil.jsonNodeToInt(_leaderIdNode, "PartitionData");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "PartitionData");
            }
            JsonNode _highWatermarkNode = _node.get("highWatermark");
            if (_highWatermarkNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'highWatermark', which is mandatory in version " + _version);
            } else {
                _object.highWatermark = MessageUtil.jsonNodeToLong(_highWatermarkNode, "PartitionData");
            }
            JsonNode _currentVotersNode = _node.get("currentVoters");
            if (_currentVotersNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'currentVoters', which is mandatory in version " + _version);
            } else {
                if (!_currentVotersNode.isArray()) {
                    throw new RuntimeException("PartitionData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<ReplicaState> _collection = new ArrayList<ReplicaState>(_currentVotersNode.size());
                _object.currentVoters = _collection;
                for (JsonNode _element : _currentVotersNode) {
                    _collection.add(ReplicaStateJsonConverter.read(_element, _version));
                }
            }
            JsonNode _observersNode = _node.get("observers");
            if (_observersNode == null) {
                throw new RuntimeException("PartitionData: unable to locate field 'observers', which is mandatory in version " + _version);
            } else {
                if (!_observersNode.isArray()) {
                    throw new RuntimeException("PartitionData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<ReplicaState> _collection = new ArrayList<ReplicaState>(_observersNode.size());
                _object.observers = _collection;
                for (JsonNode _element : _observersNode) {
                    _collection.add(ReplicaStateJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(PartitionData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("leaderId", new IntNode(_object.leaderId));
            _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            _node.set("highWatermark", new LongNode(_object.highWatermark));
            ArrayNode _currentVotersArray = new ArrayNode(JsonNodeFactory.instance);
            for (ReplicaState _element : _object.currentVoters) {
                _currentVotersArray.add(ReplicaStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("currentVoters", _currentVotersArray);
            ArrayNode _observersArray = new ArrayNode(JsonNodeFactory.instance);
            for (ReplicaState _element : _object.observers) {
                _observersArray.add(ReplicaStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("observers", _observersArray);
            return _node;
        }
        public static JsonNode write(PartitionData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ReplicaStateJsonConverter {
        public static ReplicaState read(JsonNode _node, short _version) {
            ReplicaState _object = new ReplicaState();
            JsonNode _replicaIdNode = _node.get("replicaId");
            if (_replicaIdNode == null) {
                throw new RuntimeException("ReplicaState: unable to locate field 'replicaId', which is mandatory in version " + _version);
            } else {
                _object.replicaId = MessageUtil.jsonNodeToInt(_replicaIdNode, "ReplicaState");
            }
            JsonNode _logEndOffsetNode = _node.get("logEndOffset");
            if (_logEndOffsetNode == null) {
                throw new RuntimeException("ReplicaState: unable to locate field 'logEndOffset', which is mandatory in version " + _version);
            } else {
                _object.logEndOffset = MessageUtil.jsonNodeToLong(_logEndOffsetNode, "ReplicaState");
            }
            JsonNode _lastFetchTimestampNode = _node.get("lastFetchTimestamp");
            if (_lastFetchTimestampNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("ReplicaState: unable to locate field 'lastFetchTimestamp', which is mandatory in version " + _version);
                } else {
                    _object.lastFetchTimestamp = -1L;
                }
            } else {
                _object.lastFetchTimestamp = MessageUtil.jsonNodeToLong(_lastFetchTimestampNode, "ReplicaState");
            }
            JsonNode _lastCaughtUpTimestampNode = _node.get("lastCaughtUpTimestamp");
            if (_lastCaughtUpTimestampNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("ReplicaState: unable to locate field 'lastCaughtUpTimestamp', which is mandatory in version " + _version);
                } else {
                    _object.lastCaughtUpTimestamp = -1L;
                }
            } else {
                _object.lastCaughtUpTimestamp = MessageUtil.jsonNodeToLong(_lastCaughtUpTimestampNode, "ReplicaState");
            }
            return _object;
        }
        public static JsonNode write(ReplicaState _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("replicaId", new IntNode(_object.replicaId));
            _node.set("logEndOffset", new LongNode(_object.logEndOffset));
            if (_version >= 1) {
                _node.set("lastFetchTimestamp", new LongNode(_object.lastFetchTimestamp));
            }
            if (_version >= 1) {
                _node.set("lastCaughtUpTimestamp", new LongNode(_object.lastCaughtUpTimestamp));
            }
            return _node;
        }
        public static JsonNode write(ReplicaState _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class TopicDataJsonConverter {
        public static TopicData read(JsonNode _node, short _version) {
            TopicData _object = new TopicData();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("TopicData: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("TopicData expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
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
            _node.set("topicName", new TextNode(_object.topicName));
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
