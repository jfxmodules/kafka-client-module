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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.Uuid;

import static org.apache.kafka.common.message.GetTelemetrySubscriptionsRequestData.*;

public class GetTelemetrySubscriptionsRequestDataJsonConverter {
    public static GetTelemetrySubscriptionsRequestData read(JsonNode _node, short _version) {
        GetTelemetrySubscriptionsRequestData _object = new GetTelemetrySubscriptionsRequestData();
        JsonNode _clientInstanceIdNode = _node.get("clientInstanceId");
        if (_clientInstanceIdNode == null) {
            throw new RuntimeException("GetTelemetrySubscriptionsRequestData: unable to locate field 'clientInstanceId', which is mandatory in version " + _version);
        } else {
            if (!_clientInstanceIdNode.isTextual()) {
                throw new RuntimeException("GetTelemetrySubscriptionsRequestData expected a JSON string type, but got " + _node.getNodeType());
            }
            _object.clientInstanceId = Uuid.fromString(_clientInstanceIdNode.asText());
        }
        return _object;
    }
    public static JsonNode write(GetTelemetrySubscriptionsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("clientInstanceId", new TextNode(_object.clientInstanceId.toString()));
        return _node;
    }
    public static JsonNode write(GetTelemetrySubscriptionsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
