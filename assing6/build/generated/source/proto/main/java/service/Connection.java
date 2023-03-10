// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/registry.proto

package service;

/**
 * Protobuf type {@code services.Connection}
 */
public final class Connection extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.Connection)
    ConnectionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Connection.newBuilder() to construct.
  private Connection(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Connection() {
    uri_ = "";
    protocol_ = "";
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Connection();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Connection(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            uri_ = s;
            break;
          }
          case 16: {

            discoveryPort_ = input.readInt32();
            break;
          }
          case 24: {

            port_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            protocol_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
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
    return service.RegistryProto.internal_static_services_Connection_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.RegistryProto.internal_static_services_Connection_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.Connection.class, service.Connection.Builder.class);
  }

  public static final int URI_FIELD_NUMBER = 1;
  private volatile java.lang.Object uri_;
  /**
   * <code>string uri = 1;</code>
   * @return The uri.
   */
  @java.lang.Override
  public java.lang.String getUri() {
    java.lang.Object ref = uri_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      uri_ = s;
      return s;
    }
  }
  /**
   * <code>string uri = 1;</code>
   * @return The bytes for uri.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUriBytes() {
    java.lang.Object ref = uri_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      uri_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DISCOVERYPORT_FIELD_NUMBER = 2;
  private int discoveryPort_;
  /**
   * <code>int32 discoveryPort = 2;</code>
   * @return The discoveryPort.
   */
  @java.lang.Override
  public int getDiscoveryPort() {
    return discoveryPort_;
  }

  public static final int PORT_FIELD_NUMBER = 3;
  private int port_;
  /**
   * <code>int32 port = 3;</code>
   * @return The port.
   */
  @java.lang.Override
  public int getPort() {
    return port_;
  }

  public static final int PROTOCOL_FIELD_NUMBER = 4;
  private volatile java.lang.Object protocol_;
  /**
   * <code>string protocol = 4;</code>
   * @return The protocol.
   */
  @java.lang.Override
  public java.lang.String getProtocol() {
    java.lang.Object ref = protocol_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      protocol_ = s;
      return s;
    }
  }
  /**
   * <code>string protocol = 4;</code>
   * @return The bytes for protocol.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getProtocolBytes() {
    java.lang.Object ref = protocol_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      protocol_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NAME_FIELD_NUMBER = 5;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 5;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 5;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(uri_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, uri_);
    }
    if (discoveryPort_ != 0) {
      output.writeInt32(2, discoveryPort_);
    }
    if (port_ != 0) {
      output.writeInt32(3, port_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(protocol_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, protocol_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, name_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(uri_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, uri_);
    }
    if (discoveryPort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, discoveryPort_);
    }
    if (port_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, port_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(protocol_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, protocol_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, name_);
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
    if (!(obj instanceof service.Connection)) {
      return super.equals(obj);
    }
    service.Connection other = (service.Connection) obj;

    if (!getUri()
        .equals(other.getUri())) return false;
    if (getDiscoveryPort()
        != other.getDiscoveryPort()) return false;
    if (getPort()
        != other.getPort()) return false;
    if (!getProtocol()
        .equals(other.getProtocol())) return false;
    if (!getName()
        .equals(other.getName())) return false;
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
    hash = (37 * hash) + URI_FIELD_NUMBER;
    hash = (53 * hash) + getUri().hashCode();
    hash = (37 * hash) + DISCOVERYPORT_FIELD_NUMBER;
    hash = (53 * hash) + getDiscoveryPort();
    hash = (37 * hash) + PORT_FIELD_NUMBER;
    hash = (53 * hash) + getPort();
    hash = (37 * hash) + PROTOCOL_FIELD_NUMBER;
    hash = (53 * hash) + getProtocol().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.Connection parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.Connection parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.Connection parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.Connection parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.Connection parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.Connection parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.Connection parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.Connection parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.Connection parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.Connection parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.Connection parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.Connection parseFrom(
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
  public static Builder newBuilder(service.Connection prototype) {
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
   * Protobuf type {@code services.Connection}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.Connection)
      service.ConnectionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.RegistryProto.internal_static_services_Connection_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.RegistryProto.internal_static_services_Connection_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.Connection.class, service.Connection.Builder.class);
    }

    // Construct using service.Connection.newBuilder()
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
      uri_ = "";

      discoveryPort_ = 0;

      port_ = 0;

      protocol_ = "";

      name_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.RegistryProto.internal_static_services_Connection_descriptor;
    }

    @java.lang.Override
    public service.Connection getDefaultInstanceForType() {
      return service.Connection.getDefaultInstance();
    }

    @java.lang.Override
    public service.Connection build() {
      service.Connection result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.Connection buildPartial() {
      service.Connection result = new service.Connection(this);
      result.uri_ = uri_;
      result.discoveryPort_ = discoveryPort_;
      result.port_ = port_;
      result.protocol_ = protocol_;
      result.name_ = name_;
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
      if (other instanceof service.Connection) {
        return mergeFrom((service.Connection)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.Connection other) {
      if (other == service.Connection.getDefaultInstance()) return this;
      if (!other.getUri().isEmpty()) {
        uri_ = other.uri_;
        onChanged();
      }
      if (other.getDiscoveryPort() != 0) {
        setDiscoveryPort(other.getDiscoveryPort());
      }
      if (other.getPort() != 0) {
        setPort(other.getPort());
      }
      if (!other.getProtocol().isEmpty()) {
        protocol_ = other.protocol_;
        onChanged();
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
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
      service.Connection parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.Connection) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object uri_ = "";
    /**
     * <code>string uri = 1;</code>
     * @return The uri.
     */
    public java.lang.String getUri() {
      java.lang.Object ref = uri_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        uri_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string uri = 1;</code>
     * @return The bytes for uri.
     */
    public com.google.protobuf.ByteString
        getUriBytes() {
      java.lang.Object ref = uri_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        uri_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string uri = 1;</code>
     * @param value The uri to set.
     * @return This builder for chaining.
     */
    public Builder setUri(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      uri_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string uri = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUri() {
      
      uri_ = getDefaultInstance().getUri();
      onChanged();
      return this;
    }
    /**
     * <code>string uri = 1;</code>
     * @param value The bytes for uri to set.
     * @return This builder for chaining.
     */
    public Builder setUriBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      uri_ = value;
      onChanged();
      return this;
    }

    private int discoveryPort_ ;
    /**
     * <code>int32 discoveryPort = 2;</code>
     * @return The discoveryPort.
     */
    @java.lang.Override
    public int getDiscoveryPort() {
      return discoveryPort_;
    }
    /**
     * <code>int32 discoveryPort = 2;</code>
     * @param value The discoveryPort to set.
     * @return This builder for chaining.
     */
    public Builder setDiscoveryPort(int value) {
      
      discoveryPort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 discoveryPort = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDiscoveryPort() {
      
      discoveryPort_ = 0;
      onChanged();
      return this;
    }

    private int port_ ;
    /**
     * <code>int32 port = 3;</code>
     * @return The port.
     */
    @java.lang.Override
    public int getPort() {
      return port_;
    }
    /**
     * <code>int32 port = 3;</code>
     * @param value The port to set.
     * @return This builder for chaining.
     */
    public Builder setPort(int value) {
      
      port_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 port = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPort() {
      
      port_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object protocol_ = "";
    /**
     * <code>string protocol = 4;</code>
     * @return The protocol.
     */
    public java.lang.String getProtocol() {
      java.lang.Object ref = protocol_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        protocol_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string protocol = 4;</code>
     * @return The bytes for protocol.
     */
    public com.google.protobuf.ByteString
        getProtocolBytes() {
      java.lang.Object ref = protocol_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        protocol_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string protocol = 4;</code>
     * @param value The protocol to set.
     * @return This builder for chaining.
     */
    public Builder setProtocol(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      protocol_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string protocol = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearProtocol() {
      
      protocol_ = getDefaultInstance().getProtocol();
      onChanged();
      return this;
    }
    /**
     * <code>string protocol = 4;</code>
     * @param value The bytes for protocol to set.
     * @return This builder for chaining.
     */
    public Builder setProtocolBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      protocol_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 5;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 5;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 5;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 5;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
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


    // @@protoc_insertion_point(builder_scope:services.Connection)
  }

  // @@protoc_insertion_point(class_scope:services.Connection)
  private static final service.Connection DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.Connection();
  }

  public static service.Connection getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Connection>
      PARSER = new com.google.protobuf.AbstractParser<Connection>() {
    @java.lang.Override
    public Connection parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Connection(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Connection> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Connection> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.Connection getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

