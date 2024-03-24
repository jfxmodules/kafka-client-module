/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apache.kafka.common.compress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.apache.kafka.common.utils.ByteBufferInputStream;
import org.apache.kafka.common.utils.ByteBufferOutputStream;

/**
 *
 * @author Chad Preisler
 */
public class LZ4Factory {
    public static OutputStream wrapForOutput(ByteBufferOutputStream buffer) throws IOException {
        return new LZ4FramedCompressorOutputStream(buffer);
    }

    public static InputStream wrapForInput(ByteBuffer buffer) throws IOException {
        return new FramedLZ4CompressorInputStream(new ByteBufferInputStream(buffer));
    }
}
