#include "sample_DhtRead.h"
#include "pi_dht_read.h"

JNIEXPORT jint JNICALL Java_sample_DhtRead_getTemperature(JNIEnv *env, jclass cls) {
  float humidity = 0, temperature = 0;
  int sensor = 22, pin = 22;
  int result = pi_dht_read(sensor, pin, &humidity, &temperature);
  return result;
}

JNIEXPORT jobject JNICALL Java_sample_DhtRead_getReading(JNIEnv *env, jclass cls) {
  jmethodID constructor;
  jobject object;
  jclass clazz;

  clazz = (*env)->FindClass(env,"sample/Reading");
  if (clazz == 0) { printf("Find Class failed.\n"); }
  else { printf("Find Class OK\n"); }

  constructor = (*env)->GetMethodID(env,clazz,"<init>","(FF)V");
  if (constructor == 0) { printf("Find Method failed.\n"); }
  else { printf("Find Method OK.\n"); }

  float humidity = 0, temperature = 0;
  int sensor = 22, pin = 22;
  int result = pi_dht_read(sensor, pin, &humidity, &temperature);
  printf("Result is %d; Temperature: %d, Humidity: %d\n", result, &temperature, &humidity);

  object = (*env)->NewObject(env,clazz,constructor,&temperature,&humidity);

  return object;
}
