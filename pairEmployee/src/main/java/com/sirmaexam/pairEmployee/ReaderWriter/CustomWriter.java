package com.sirmaexam.pairEmployee.ReaderWriter;

import java.io.Serializable;
import java.util.List;

public interface CustomWriter {
    void write (List<Serializable> employees, String filename);
}
