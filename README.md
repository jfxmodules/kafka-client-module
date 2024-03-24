# jfxmodules Kafka Client Module

This module is taken from the Apache Kafka project. The goal of this project
is to make the Apache Client library an offical Java module. This project
is in no way related to offical Apache Kafka project. There is no active
development being done here to change or enhance the Kafka client. This code is
currently taken from the 3.7.0 release.

# Changes

All changes made can be seen in the diff.out file; however, here are the highlights.

- Generated source code was built by the Apache Kafka build and copied to the
java/src directory. This consists of classes in the org.apache.kafka.common.message
package.
- The io.opentelemetry.proto opentelemetry-proto dependencey was removed because
it is not a proper java module. Because of this, the following changes were
made to classes the used telementy:
    - The classes in package org.apache.kafka.common.telemetry.internals 
was highly commented out.
    - Completely removed org.apache.kafka.common.telemetry.internals.SinglePointMetric
    - All unit tests in org.apache.kafka.common.telemetry.internals were removed.

- The following compression types in org.apache.kafka.common.compress now use Apache
commons-compress:
    - LZ4
    - SnappyFactory
    - ZSTD
- The following classes are removed because they are no longer needed:
    - org.apache.kafka.common.compress.KafkaLZ4BlockInputStream
    - org.apache.kafka.common.compress.KafkaLZ4BlockOutputStream
- The following class was changed to support commons-compress for LZ4 and Snappy:
    - org.apache.kafka.common.record.CompressionType
- Because of the change to commons-compress RecordBatch.MAGIC_VALUE_V0 is no longer supported for
  CompressionType.ZSTD.
- Because of the change to commons-compress RecordBatch.MAGIC_VALUE_V0 is no longer 
supported fo LZ4 compression.
- org.apache.kafka.common.record.CompressionTypeTest is removed becuase it is
no longer relevant to this version.
- The org.apache.kafka.common.telemetry.internals test were removed, because
the telemetry dependency was removed, and the telememtry classes were highly
commented.
- Moved generated-test from original Kakfa Client build to src/test/java
-The CommonNameLoggingTrustManagerFactoryWrapperTest had two tests change. For some
reason the log appender was not working. The tests that were changed are:
    - testCommonNameLoggingTrustManagerWithExpiredEndCert
    - testCommonNameLoggingTrustManagerWithExpiredEndCertWithCA


### License
Apache License Version 2.0

    