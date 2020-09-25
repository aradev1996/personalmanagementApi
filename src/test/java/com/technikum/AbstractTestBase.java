package com.technikum;

import com.technikum.personalmanagement.ObjectRandomizer;

public abstract class AbstractTestBase {

    protected ObjectRandomizer randomizer() {
        return new ObjectRandomizer();
    }
}
