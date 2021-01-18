// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/config/enforcer/auth_service.proto

package org.wso2.gateway.discovery.config.enforcer;

public interface AuthServiceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:discovery.config.enforcer.AuthService)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 port = 1;</code>
   * @return The port.
   */
  int getPort();

  /**
   * <code>int32 maxMessageSize = 2;</code>
   * @return The maxMessageSize.
   */
  int getMaxMessageSize();

  /**
   * <code>int32 maxHeaderLimit = 3;</code>
   * @return The maxHeaderLimit.
   */
  int getMaxHeaderLimit();

  /**
   * <pre>
   * keep alive time of the external authz connection
   * </pre>
   *
   * <code>int32 keepAliveTime = 4;</code>
   * @return The keepAliveTime.
   */
  int getKeepAliveTime();

  /**
   * <code>.discovery.config.enforcer.ThreadPool threadPool = 5;</code>
   * @return Whether the threadPool field is set.
   */
  boolean hasThreadPool();
  /**
   * <code>.discovery.config.enforcer.ThreadPool threadPool = 5;</code>
   * @return The threadPool.
   */
  org.wso2.gateway.discovery.config.enforcer.ThreadPool getThreadPool();
  /**
   * <code>.discovery.config.enforcer.ThreadPool threadPool = 5;</code>
   */
  org.wso2.gateway.discovery.config.enforcer.ThreadPoolOrBuilder getThreadPoolOrBuilder();
}
