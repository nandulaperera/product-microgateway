// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/config/enforcer/event_hub.proto

package org.wso2.gateway.discovery.config.enforcer;

public interface EventHubOrBuilder extends
    // @@protoc_insertion_point(interface_extends:discovery.config.enforcer.EventHub)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Is Eventhub based resource change detection enabled or not
   * </pre>
   *
   * <code>bool enabled = 1;</code>
   * @return The enabled.
   */
  boolean getEnabled();

  /**
   * <pre>
   * Eventhub service url
   * Generally this is APIM server url
   * </pre>
   *
   * <code>string serviceUrl = 2;</code>
   * @return The serviceUrl.
   */
  java.lang.String getServiceUrl();
  /**
   * <pre>
   * Eventhub service url
   * Generally this is APIM server url
   * </pre>
   *
   * <code>string serviceUrl = 2;</code>
   * @return The bytes for serviceUrl.
   */
  com.google.protobuf.ByteString
      getServiceUrlBytes();

  /**
   * <pre>
   * Endpoint to be used as the dynamic change detection endpoint
   * Ex: "amqp://admin:admin&#64;carbon/carbon?brokerlist='tcp://localhost:5672'"
   * </pre>
   *
   * <code>string listenerEndpoint = 3;</code>
   * @return The listenerEndpoint.
   */
  java.lang.String getListenerEndpoint();
  /**
   * <pre>
   * Endpoint to be used as the dynamic change detection endpoint
   * Ex: "amqp://admin:admin&#64;carbon/carbon?brokerlist='tcp://localhost:5672'"
   * </pre>
   *
   * <code>string listenerEndpoint = 3;</code>
   * @return The bytes for listenerEndpoint.
   */
  com.google.protobuf.ByteString
      getListenerEndpointBytes();
}
