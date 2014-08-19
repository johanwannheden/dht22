#include sample_DhtRead.h
#include pi_dht_read.h

JNIEXPORT jint JNICALL Java_sample_DhtRead_getTemperature
  (JNIEnv *, jclass) {
  return 78;
}