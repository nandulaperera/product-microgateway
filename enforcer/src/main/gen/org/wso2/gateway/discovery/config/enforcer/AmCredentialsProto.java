// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/config/enforcer/am_credentials.proto

package org.wso2.gateway.discovery.config.enforcer;

public final class AmCredentialsProto {
  private AmCredentialsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_discovery_config_enforcer_AmCredentials_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_discovery_config_enforcer_AmCredentials_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n3wso2/discovery/config/enforcer/am_cred" +
      "entials.proto\022\031discovery.config.enforcer" +
      "\"3\n\rAmCredentials\022\020\n\010username\030\001 \001(\t\022\020\n\010p" +
      "assword\030\002 \001(\tB\222\001\n*org.wso2.gateway.disco" +
      "very.config.enforcerB\022AmCredentialsProto" +
      "P\001ZNgithub.com/envoyproxy/go-control-pla" +
      "ne/wso2/discovery/config/enforcer;enforc" +
      "erb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_discovery_config_enforcer_AmCredentials_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_discovery_config_enforcer_AmCredentials_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_discovery_config_enforcer_AmCredentials_descriptor,
        new java.lang.String[] { "Username", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
