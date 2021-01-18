// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/config/enforcer/thread_pool.proto

package org.wso2.gateway.discovery.config.enforcer;

/**
 * <pre>
 * ThreadPool model
 * </pre>
 *
 * Protobuf type {@code discovery.config.enforcer.ThreadPool}
 */
public final class ThreadPool extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:discovery.config.enforcer.ThreadPool)
    ThreadPoolOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ThreadPool.newBuilder() to construct.
  private ThreadPool(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ThreadPool() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ThreadPool();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ThreadPool(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            coreSize_ = input.readInt32();
            break;
          }
          case 16: {

            maxSize_ = input.readInt32();
            break;
          }
          case 32: {

            keepAliveTime_ = input.readInt32();
            break;
          }
          case 40: {

            queueSize_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.wso2.gateway.discovery.config.enforcer.ThreadPoolProto.internal_static_discovery_config_enforcer_ThreadPool_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.wso2.gateway.discovery.config.enforcer.ThreadPoolProto.internal_static_discovery_config_enforcer_ThreadPool_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.wso2.gateway.discovery.config.enforcer.ThreadPool.class, org.wso2.gateway.discovery.config.enforcer.ThreadPool.Builder.class);
  }

  public static final int CORESIZE_FIELD_NUMBER = 1;
  private int coreSize_;
  /**
   * <code>int32 coreSize = 1;</code>
   * @return The coreSize.
   */
  @java.lang.Override
  public int getCoreSize() {
    return coreSize_;
  }

  public static final int MAXSIZE_FIELD_NUMBER = 2;
  private int maxSize_;
  /**
   * <code>int32 maxSize = 2;</code>
   * @return The maxSize.
   */
  @java.lang.Override
  public int getMaxSize() {
    return maxSize_;
  }

  public static final int KEEPALIVETIME_FIELD_NUMBER = 4;
  private int keepAliveTime_;
  /**
   * <pre>
   * keep alive time of threads in seconds
   * </pre>
   *
   * <code>int32 keepAliveTime = 4;</code>
   * @return The keepAliveTime.
   */
  @java.lang.Override
  public int getKeepAliveTime() {
    return keepAliveTime_;
  }

  public static final int QUEUESIZE_FIELD_NUMBER = 5;
  private int queueSize_;
  /**
   * <code>int32 queueSize = 5;</code>
   * @return The queueSize.
   */
  @java.lang.Override
  public int getQueueSize() {
    return queueSize_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (coreSize_ != 0) {
      output.writeInt32(1, coreSize_);
    }
    if (maxSize_ != 0) {
      output.writeInt32(2, maxSize_);
    }
    if (keepAliveTime_ != 0) {
      output.writeInt32(4, keepAliveTime_);
    }
    if (queueSize_ != 0) {
      output.writeInt32(5, queueSize_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (coreSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, coreSize_);
    }
    if (maxSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, maxSize_);
    }
    if (keepAliveTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, keepAliveTime_);
    }
    if (queueSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, queueSize_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.wso2.gateway.discovery.config.enforcer.ThreadPool)) {
      return super.equals(obj);
    }
    org.wso2.gateway.discovery.config.enforcer.ThreadPool other = (org.wso2.gateway.discovery.config.enforcer.ThreadPool) obj;

    if (getCoreSize()
        != other.getCoreSize()) return false;
    if (getMaxSize()
        != other.getMaxSize()) return false;
    if (getKeepAliveTime()
        != other.getKeepAliveTime()) return false;
    if (getQueueSize()
        != other.getQueueSize()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CORESIZE_FIELD_NUMBER;
    hash = (53 * hash) + getCoreSize();
    hash = (37 * hash) + MAXSIZE_FIELD_NUMBER;
    hash = (53 * hash) + getMaxSize();
    hash = (37 * hash) + KEEPALIVETIME_FIELD_NUMBER;
    hash = (53 * hash) + getKeepAliveTime();
    hash = (37 * hash) + QUEUESIZE_FIELD_NUMBER;
    hash = (53 * hash) + getQueueSize();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.wso2.gateway.discovery.config.enforcer.ThreadPool prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * ThreadPool model
   * </pre>
   *
   * Protobuf type {@code discovery.config.enforcer.ThreadPool}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:discovery.config.enforcer.ThreadPool)
      org.wso2.gateway.discovery.config.enforcer.ThreadPoolOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.wso2.gateway.discovery.config.enforcer.ThreadPoolProto.internal_static_discovery_config_enforcer_ThreadPool_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.wso2.gateway.discovery.config.enforcer.ThreadPoolProto.internal_static_discovery_config_enforcer_ThreadPool_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.wso2.gateway.discovery.config.enforcer.ThreadPool.class, org.wso2.gateway.discovery.config.enforcer.ThreadPool.Builder.class);
    }

    // Construct using org.wso2.gateway.discovery.config.enforcer.ThreadPool.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      coreSize_ = 0;

      maxSize_ = 0;

      keepAliveTime_ = 0;

      queueSize_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.wso2.gateway.discovery.config.enforcer.ThreadPoolProto.internal_static_discovery_config_enforcer_ThreadPool_descriptor;
    }

    @java.lang.Override
    public org.wso2.gateway.discovery.config.enforcer.ThreadPool getDefaultInstanceForType() {
      return org.wso2.gateway.discovery.config.enforcer.ThreadPool.getDefaultInstance();
    }

    @java.lang.Override
    public org.wso2.gateway.discovery.config.enforcer.ThreadPool build() {
      org.wso2.gateway.discovery.config.enforcer.ThreadPool result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.wso2.gateway.discovery.config.enforcer.ThreadPool buildPartial() {
      org.wso2.gateway.discovery.config.enforcer.ThreadPool result = new org.wso2.gateway.discovery.config.enforcer.ThreadPool(this);
      result.coreSize_ = coreSize_;
      result.maxSize_ = maxSize_;
      result.keepAliveTime_ = keepAliveTime_;
      result.queueSize_ = queueSize_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.wso2.gateway.discovery.config.enforcer.ThreadPool) {
        return mergeFrom((org.wso2.gateway.discovery.config.enforcer.ThreadPool)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.wso2.gateway.discovery.config.enforcer.ThreadPool other) {
      if (other == org.wso2.gateway.discovery.config.enforcer.ThreadPool.getDefaultInstance()) return this;
      if (other.getCoreSize() != 0) {
        setCoreSize(other.getCoreSize());
      }
      if (other.getMaxSize() != 0) {
        setMaxSize(other.getMaxSize());
      }
      if (other.getKeepAliveTime() != 0) {
        setKeepAliveTime(other.getKeepAliveTime());
      }
      if (other.getQueueSize() != 0) {
        setQueueSize(other.getQueueSize());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.wso2.gateway.discovery.config.enforcer.ThreadPool parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.wso2.gateway.discovery.config.enforcer.ThreadPool) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int coreSize_ ;
    /**
     * <code>int32 coreSize = 1;</code>
     * @return The coreSize.
     */
    @java.lang.Override
    public int getCoreSize() {
      return coreSize_;
    }
    /**
     * <code>int32 coreSize = 1;</code>
     * @param value The coreSize to set.
     * @return This builder for chaining.
     */
    public Builder setCoreSize(int value) {
      
      coreSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 coreSize = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCoreSize() {
      
      coreSize_ = 0;
      onChanged();
      return this;
    }

    private int maxSize_ ;
    /**
     * <code>int32 maxSize = 2;</code>
     * @return The maxSize.
     */
    @java.lang.Override
    public int getMaxSize() {
      return maxSize_;
    }
    /**
     * <code>int32 maxSize = 2;</code>
     * @param value The maxSize to set.
     * @return This builder for chaining.
     */
    public Builder setMaxSize(int value) {
      
      maxSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 maxSize = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMaxSize() {
      
      maxSize_ = 0;
      onChanged();
      return this;
    }

    private int keepAliveTime_ ;
    /**
     * <pre>
     * keep alive time of threads in seconds
     * </pre>
     *
     * <code>int32 keepAliveTime = 4;</code>
     * @return The keepAliveTime.
     */
    @java.lang.Override
    public int getKeepAliveTime() {
      return keepAliveTime_;
    }
    /**
     * <pre>
     * keep alive time of threads in seconds
     * </pre>
     *
     * <code>int32 keepAliveTime = 4;</code>
     * @param value The keepAliveTime to set.
     * @return This builder for chaining.
     */
    public Builder setKeepAliveTime(int value) {
      
      keepAliveTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * keep alive time of threads in seconds
     * </pre>
     *
     * <code>int32 keepAliveTime = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearKeepAliveTime() {
      
      keepAliveTime_ = 0;
      onChanged();
      return this;
    }

    private int queueSize_ ;
    /**
     * <code>int32 queueSize = 5;</code>
     * @return The queueSize.
     */
    @java.lang.Override
    public int getQueueSize() {
      return queueSize_;
    }
    /**
     * <code>int32 queueSize = 5;</code>
     * @param value The queueSize to set.
     * @return This builder for chaining.
     */
    public Builder setQueueSize(int value) {
      
      queueSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 queueSize = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearQueueSize() {
      
      queueSize_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:discovery.config.enforcer.ThreadPool)
  }

  // @@protoc_insertion_point(class_scope:discovery.config.enforcer.ThreadPool)
  private static final org.wso2.gateway.discovery.config.enforcer.ThreadPool DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.wso2.gateway.discovery.config.enforcer.ThreadPool();
  }

  public static org.wso2.gateway.discovery.config.enforcer.ThreadPool getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ThreadPool>
      PARSER = new com.google.protobuf.AbstractParser<ThreadPool>() {
    @java.lang.Override
    public ThreadPool parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ThreadPool(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ThreadPool> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ThreadPool> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.wso2.gateway.discovery.config.enforcer.ThreadPool getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

