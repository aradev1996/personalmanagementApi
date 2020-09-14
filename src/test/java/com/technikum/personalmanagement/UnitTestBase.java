package com.technikum.personalmanagement;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Path;

@ExtendWith(SpringExtension.class)
public abstract class UnitTestBase {

  protected ObjectRandomizer randomizer() {
    return new ObjectRandomizer();
  }
}
