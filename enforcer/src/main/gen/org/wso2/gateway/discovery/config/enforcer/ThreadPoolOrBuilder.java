// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/config/enforcer/thread_pool.proto

package org.wso2.gateway.discovery.config.enforcer;

public interface ThreadPoolOrBuilder extends
    // @@protoc_insertion_point(interface_extends:discovery.config.enforcer.ThreadPool)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 coreSize = 1;</code>
   * @return The coreSize.
   */
  int getCoreSize();

  /**
   * <code>int32 maxSize = 2;</code>
   * @return The maxSize.
   */
  int getMaxSize();

  /**
   * <pre>
   * keep alive time of threads in seconds
   * </pre>
   *
   * <code>int32 keepAliveTime = 4;</code>
   * @return The keepAliveTime.
   */
  int getKeepAliveTime();

  /**
   * <code>int32 queueSize = 5;</code>
   * @return The queueSize.
   */
  int getQueueSize();
}
