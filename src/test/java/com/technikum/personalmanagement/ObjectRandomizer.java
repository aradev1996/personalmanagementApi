package com.technikum.personalmanagement;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unchecked, rawtypes, unused")
public class ObjectRandomizer {

  public EasyRandomParameters defaultParams = defaultParams();

  public <T> T createRandomObject(final Class<T> clazz) {
    return new EasyRandom(defaultParams).nextObject(clazz);
  }

  public ObjectRandomizer appendFixedObject(Class clazz, Object value) {
    this.defaultParams.randomize(clazz, () -> value);
    return this;
  }

  public ObjectRandomizer appendFixedField(String name, Object value, Class inClass) {
    defaultParams
        .randomize(FieldPredicates.named(name).and(FieldPredicates.inClass(inClass)), () -> value);
    return this;
  }

  public ObjectRandomizer buildParams(EasyRandomParameters params) {
    this.defaultParams = params;
    return this;
  }

  private EasyRandomParameters defaultParams() {
    return new EasyRandomParameters()
        .charset(StandardCharsets.UTF_8)
        .overrideDefaultInitialization(true)
        .randomizationDepth(5)
        .stringLengthRange(1, 4)
        .collectionSizeRange(1, 2)
        .scanClasspathForConcreteTypes(true)
        .randomize(Integer.class, () -> ThreadLocalRandom.current().nextInt(1, 100 + 1))
        .randomize(File.class, () -> new File("test.txt"));
  }
}
