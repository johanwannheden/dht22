#include "DhtRead.h"
#include "pi_dht_read.h"

JNIEXPORT jint JNICALL Java_DhtRead_getTemperature
(JNIEnv *env, jclass cls) {
  return 78;
}
