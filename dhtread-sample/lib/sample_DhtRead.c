#include "sample_DhtRead.h"
#include "pi_dht_read.h"

JNIEXPORT jint JNICALL Java_sample_DhtRead_getTemperature
  (JNIEnv *env, jclass cls) {
  float humidity = 0, temperature = 0;
  int sensor = 22, pin = 22;
  int result = pi_dht_read(sensor, pin, &humidity, &temperature);
  return result;
}
