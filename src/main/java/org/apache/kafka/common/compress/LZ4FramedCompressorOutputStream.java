/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apache.kafka.common.compress;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream;
import org.apache.kafka.common.KafkaException;

/**
 *
 * @author Chad Preisler
 */
public class LZ4FramedCompressorOutputStream extends FramedLZ4CompressorOutputStream {
    
    public LZ4FramedCompressorOutputStream(OutputStream out) throws IOException {
        super(out, new Parameters(BlockSize.K64, false, false, false));
    }
    
    public void flush() {
        try {
            finish();
        } catch (IOException ex) {
            throw new KafkaException(ex);
        }
    }
    
}
