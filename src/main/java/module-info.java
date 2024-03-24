/*
 * Copyright 2024 Chad Preisler.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

module org.jfxmodules.kafka.clients {
    requires java.security.sasl;
    requires java.security.jgss;
    requires java.management;
    requires org.slf4j;
    requires org.apache.commons.compress;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires org.jfxmodules.jose4j;
    
    exports org.apache.kafka.clients;
    exports org.apache.kafka.clients.admin;
    exports org.apache.kafka.clients.consumer;
    exports org.apache.kafka.clients.producer;
    
    exports org.apache.kafka.common;
    exports org.apache.kafka.common.config;
    exports org.apache.kafka.common.acl;
    exports org.apache.kafka.common.annotation;
    exports org.apache.kafka.common.config.provider;
    exports org.apache.kafka.common.errors;
    exports org.apache.kafka.common.header;
    exports org.apache.kafka.common.metrics;
    exports org.apache.kafka.common.metrics.stats;
    exports org.apache.kafka.common.quota;
    exports org.apache.kafka.common.resource;
    exports org.apache.kafka.common.security;
    exports org.apache.kafka.common.security.auth;
    exports org.apache.kafka.common.security.oauthbearer;
    exports org.apache.kafka.common.security.oauthbearer.secured;
    exports org.apache.kafka.common.security.plain;
    exports org.apache.kafka.common.security.scram;
    exports org.apache.kafka.common.security.ssl;
    exports org.apache.kafka.common.security.token.delegation;
    exports org.apache.kafka.common.serialization;
    exports org.apache.kafka.server.authorizer;
    exports org.apache.kafka.server.policy;
    exports org.apache.kafka.server.quota;
}
