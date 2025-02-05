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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.BrokerHeartbeatRequestData.*;

public class BrokerHeartbeatRequestDataJsonConverter {
    public static BrokerHeartbeatRequestData read(JsonNode _node, short _version) {
        BrokerHeartbeatRequestData _object = new BrokerHeartbeatRequestData();
        JsonNode _brokerIdNode = _node.get("brokerId");
        if (_brokerIdNode == null) {
            throw new RuntimeException("BrokerHeartbeatRequestData: unable to locate field 'brokerId', which is mandatory in version " + _version);
        } else {
            _object.brokerId = MessageUtil.jsonNodeToInt(_brokerIdNode, "BrokerHeartbeatRequestData");
        }
        JsonNode _brokerEpochNode = _node.get("brokerEpoch");
        if (_brokerEpochNode == null) {
            throw new RuntimeException("BrokerHeartbeatRequestData: unable to locate field 'brokerEpoch', which is mandatory in version " + _version);
        } else {
            _object.brokerEpoch = MessageUtil.jsonNodeToLong(_brokerEpochNode, "BrokerHeartbeatRequestData");
        }
        JsonNode _currentMetadataOffsetNode = _node.get("currentMetadataOffset");
        if (_currentMetadataOffsetNode == null) {
            throw new RuntimeException("BrokerHeartbeatRequestData: unable to locate field 'currentMetadataOffset', which is mandatory in version " + _version);
        } else {
            _object.currentMetadataOffset = MessageUtil.jsonNodeToLong(_currentMetadataOffsetNode, "BrokerHeartbeatRequestData");
        }
        JsonNode _wantFenceNode = _node.get("wantFence");
        if (_wantFenceNode == null) {
            throw new RuntimeException("BrokerHeartbeatRequestData: unable to locate field 'wantFence', which is mandatory in version " + _version);
        } else {
            if (!_wantFenceNode.isBoolean()) {
                throw new RuntimeException("BrokerHeartbeatRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.wantFence = _wantFenceNode.asBoolean();
        }
        JsonNode _wantShutDownNode = _node.get("wantShutDown");
        if (_wantShutDownNode == null) {
            throw new RuntimeException("BrokerHeartbeatRequestData: unable to locate field 'wantShutDown', which is mandatory in version " + _version);
        } else {
            if (!_wantShutDownNode.isBoolean()) {
                throw new RuntimeException("BrokerHeartbeatRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.wantShutDown = _wantShutDownNode.asBoolean();
        }
        JsonNode _offlineLogDirsNode = _node.get("offlineLogDirs");
        if (_offlineLogDirsNode == null) {
            _object.offlineLogDirs = new ArrayList<Uuid>(0);
        } else {
            if (!_offlineLogDirsNode.isArray()) {
                throw new RuntimeException("BrokerHeartbeatRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<Uuid> _collection = new ArrayList<Uuid>(_offlineLogDirsNode.size());
            _object.offlineLogDirs = _collection;
            for (JsonNode _element : _offlineLogDirsNode) {
                if (!_element.isTextual()) {
                    throw new RuntimeException("BrokerHeartbeatRequestData element expected a JSON string type, but got " + _node.getNodeType());
                }
                _collection.add(Uuid.fromString(_element.asText()));
            }
        }
        return _object;
    }
    public static JsonNode write(BrokerHeartbeatRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("brokerId", new IntNode(_object.brokerId));
        _node.set("brokerEpoch", new LongNode(_object.brokerEpoch));
        _node.set("currentMetadataOffset", new LongNode(_object.currentMetadataOffset));
        _node.set("wantFence", BooleanNode.valueOf(_object.wantFence));
        _node.set("wantShutDown", BooleanNode.valueOf(_object.wantShutDown));
        if (_version >= 1) {
            if (!_object.offlineLogDirs.isEmpty()) {
                ArrayNode _offlineLogDirsArray = new ArrayNode(JsonNodeFactory.instance);
                for (Uuid _element : _object.offlineLogDirs) {
                    _offlineLogDirsArray.add(new TextNode(_element.toString()));
                }
                _node.set("offlineLogDirs", _offlineLogDirsArray);
            }
        } else {
            if (!_object.offlineLogDirs.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default offlineLogDirs at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(BrokerHeartbeatRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
