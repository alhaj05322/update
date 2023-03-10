// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/timer.proto

package service;

/**
 * <pre>
 * Returns a list of Timers
 * </pre>
 *
 * Protobuf type {@code services.TimerList}
 */
public final class TimerList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.TimerList)
    TimerListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TimerList.newBuilder() to construct.
  private TimerList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TimerList() {
    timers_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TimerList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TimerList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              timers_ = new java.util.ArrayList<service.Time>();
              mutable_bitField0_ |= 0x00000001;
            }
            timers_.add(
                input.readMessage(service.Time.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        timers_ = java.util.Collections.unmodifiableList(timers_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return service.TimerProto.internal_static_services_TimerList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.TimerProto.internal_static_services_TimerList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.TimerList.class, service.TimerList.Builder.class);
  }

  public static final int TIMERS_FIELD_NUMBER = 1;
  private java.util.List<service.Time> timers_;
  /**
   * <code>repeated .services.Time timers = 1;</code>
   */
  @java.lang.Override
  public java.util.List<service.Time> getTimersList() {
    return timers_;
  }
  /**
   * <code>repeated .services.Time timers = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends service.TimeOrBuilder> 
      getTimersOrBuilderList() {
    return timers_;
  }
  /**
   * <code>repeated .services.Time timers = 1;</code>
   */
  @java.lang.Override
  public int getTimersCount() {
    return timers_.size();
  }
  /**
   * <code>repeated .services.Time timers = 1;</code>
   */
  @java.lang.Override
  public service.Time getTimers(int index) {
    return timers_.get(index);
  }
  /**
   * <code>repeated .services.Time timers = 1;</code>
   */
  @java.lang.Override
  public service.TimeOrBuilder getTimersOrBuilder(
      int index) {
    return timers_.get(index);
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
    for (int i = 0; i < timers_.size(); i++) {
      output.writeMessage(1, timers_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < timers_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, timers_.get(i));
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
    if (!(obj instanceof service.TimerList)) {
      return super.equals(obj);
    }
    service.TimerList other = (service.TimerList) obj;

    if (!getTimersList()
        .equals(other.getTimersList())) return false;
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
    if (getTimersCount() > 0) {
      hash = (37 * hash) + TIMERS_FIELD_NUMBER;
      hash = (53 * hash) + getTimersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.TimerList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.TimerList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.TimerList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.TimerList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.TimerList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.TimerList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.TimerList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.TimerList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.TimerList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.TimerList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.TimerList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.TimerList parseFrom(
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
  public static Builder newBuilder(service.TimerList prototype) {
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
   * Returns a list of Timers
   * </pre>
   *
   * Protobuf type {@code services.TimerList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.TimerList)
      service.TimerListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.TimerProto.internal_static_services_TimerList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.TimerProto.internal_static_services_TimerList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.TimerList.class, service.TimerList.Builder.class);
    }

    // Construct using service.TimerList.newBuilder()
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
        getTimersFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (timersBuilder_ == null) {
        timers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        timersBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.TimerProto.internal_static_services_TimerList_descriptor;
    }

    @java.lang.Override
    public service.TimerList getDefaultInstanceForType() {
      return service.TimerList.getDefaultInstance();
    }

    @java.lang.Override
    public service.TimerList build() {
      service.TimerList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.TimerList buildPartial() {
      service.TimerList result = new service.TimerList(this);
      int from_bitField0_ = bitField0_;
      if (timersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          timers_ = java.util.Collections.unmodifiableList(timers_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.timers_ = timers_;
      } else {
        result.timers_ = timersBuilder_.build();
      }
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
      if (other instanceof service.TimerList) {
        return mergeFrom((service.TimerList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.TimerList other) {
      if (other == service.TimerList.getDefaultInstance()) return this;
      if (timersBuilder_ == null) {
        if (!other.timers_.isEmpty()) {
          if (timers_.isEmpty()) {
            timers_ = other.timers_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTimersIsMutable();
            timers_.addAll(other.timers_);
          }
          onChanged();
        }
      } else {
        if (!other.timers_.isEmpty()) {
          if (timersBuilder_.isEmpty()) {
            timersBuilder_.dispose();
            timersBuilder_ = null;
            timers_ = other.timers_;
            bitField0_ = (bitField0_ & ~0x00000001);
            timersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTimersFieldBuilder() : null;
          } else {
            timersBuilder_.addAllMessages(other.timers_);
          }
        }
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
      service.TimerList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.TimerList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<service.Time> timers_ =
      java.util.Collections.emptyList();
    private void ensureTimersIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        timers_ = new java.util.ArrayList<service.Time>(timers_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        service.Time, service.Time.Builder, service.TimeOrBuilder> timersBuilder_;

    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public java.util.List<service.Time> getTimersList() {
      if (timersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(timers_);
      } else {
        return timersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public int getTimersCount() {
      if (timersBuilder_ == null) {
        return timers_.size();
      } else {
        return timersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public service.Time getTimers(int index) {
      if (timersBuilder_ == null) {
        return timers_.get(index);
      } else {
        return timersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder setTimers(
        int index, service.Time value) {
      if (timersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTimersIsMutable();
        timers_.set(index, value);
        onChanged();
      } else {
        timersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder setTimers(
        int index, service.Time.Builder builderForValue) {
      if (timersBuilder_ == null) {
        ensureTimersIsMutable();
        timers_.set(index, builderForValue.build());
        onChanged();
      } else {
        timersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder addTimers(service.Time value) {
      if (timersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTimersIsMutable();
        timers_.add(value);
        onChanged();
      } else {
        timersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder addTimers(
        int index, service.Time value) {
      if (timersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTimersIsMutable();
        timers_.add(index, value);
        onChanged();
      } else {
        timersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder addTimers(
        service.Time.Builder builderForValue) {
      if (timersBuilder_ == null) {
        ensureTimersIsMutable();
        timers_.add(builderForValue.build());
        onChanged();
      } else {
        timersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder addTimers(
        int index, service.Time.Builder builderForValue) {
      if (timersBuilder_ == null) {
        ensureTimersIsMutable();
        timers_.add(index, builderForValue.build());
        onChanged();
      } else {
        timersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder addAllTimers(
        java.lang.Iterable<? extends service.Time> values) {
      if (timersBuilder_ == null) {
        ensureTimersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, timers_);
        onChanged();
      } else {
        timersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder clearTimers() {
      if (timersBuilder_ == null) {
        timers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        timersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public Builder removeTimers(int index) {
      if (timersBuilder_ == null) {
        ensureTimersIsMutable();
        timers_.remove(index);
        onChanged();
      } else {
        timersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public service.Time.Builder getTimersBuilder(
        int index) {
      return getTimersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public service.TimeOrBuilder getTimersOrBuilder(
        int index) {
      if (timersBuilder_ == null) {
        return timers_.get(index);  } else {
        return timersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public java.util.List<? extends service.TimeOrBuilder> 
         getTimersOrBuilderList() {
      if (timersBuilder_ != null) {
        return timersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(timers_);
      }
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public service.Time.Builder addTimersBuilder() {
      return getTimersFieldBuilder().addBuilder(
          service.Time.getDefaultInstance());
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public service.Time.Builder addTimersBuilder(
        int index) {
      return getTimersFieldBuilder().addBuilder(
          index, service.Time.getDefaultInstance());
    }
    /**
     * <code>repeated .services.Time timers = 1;</code>
     */
    public java.util.List<service.Time.Builder> 
         getTimersBuilderList() {
      return getTimersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        service.Time, service.Time.Builder, service.TimeOrBuilder> 
        getTimersFieldBuilder() {
      if (timersBuilder_ == null) {
        timersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            service.Time, service.Time.Builder, service.TimeOrBuilder>(
                timers_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        timers_ = null;
      }
      return timersBuilder_;
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


    // @@protoc_insertion_point(builder_scope:services.TimerList)
  }

  // @@protoc_insertion_point(class_scope:services.TimerList)
  private static final service.TimerList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.TimerList();
  }

  public static service.TimerList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TimerList>
      PARSER = new com.google.protobuf.AbstractParser<TimerList>() {
    @java.lang.Override
    public TimerList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TimerList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TimerList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TimerList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.TimerList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

