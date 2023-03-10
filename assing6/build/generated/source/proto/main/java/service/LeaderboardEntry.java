// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/rockpaperscissors.proto

package service;

/**
 * <pre>
 * One entry in the leaderboard
 * </pre>
 *
 * Protobuf type {@code services.LeaderboardEntry}
 */
public final class LeaderboardEntry extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.LeaderboardEntry)
    LeaderboardEntryOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LeaderboardEntry.newBuilder() to construct.
  private LeaderboardEntry(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LeaderboardEntry() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LeaderboardEntry();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LeaderboardEntry(
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

            name_ = s;
            break;
          }
          case 16: {

            rank_ = input.readInt32();
            break;
          }
          case 24: {

            wins_ = input.readInt32();
            break;
          }
          case 32: {

            lost_ = input.readInt32();
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
    return service.RockPaperScissorsProto.internal_static_services_LeaderboardEntry_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.RockPaperScissorsProto.internal_static_services_LeaderboardEntry_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.LeaderboardEntry.class, service.LeaderboardEntry.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <pre>
   * name of player
   * </pre>
   *
   * <code>string name = 1;</code>
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
   * <pre>
   * name of player
   * </pre>
   *
   * <code>string name = 1;</code>
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

  public static final int RANK_FIELD_NUMBER = 2;
  private int rank_;
  /**
   * <pre>
   * you can rank any way you like, based only on wins or on diff between won and lost games or whatever you come up with 
   * </pre>
   *
   * <code>int32 rank = 2;</code>
   * @return The rank.
   */
  @java.lang.Override
  public int getRank() {
    return rank_;
  }

  public static final int WINS_FIELD_NUMBER = 3;
  private int wins_;
  /**
   * <pre>
   * number of wins
   * </pre>
   *
   * <code>int32 wins = 3;</code>
   * @return The wins.
   */
  @java.lang.Override
  public int getWins() {
    return wins_;
  }

  public static final int LOST_FIELD_NUMBER = 4;
  private int lost_;
  /**
   * <pre>
   * number of lost games 
   * </pre>
   *
   * <code>int32 lost = 4;</code>
   * @return The lost.
   */
  @java.lang.Override
  public int getLost() {
    return lost_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (rank_ != 0) {
      output.writeInt32(2, rank_);
    }
    if (wins_ != 0) {
      output.writeInt32(3, wins_);
    }
    if (lost_ != 0) {
      output.writeInt32(4, lost_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (rank_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, rank_);
    }
    if (wins_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, wins_);
    }
    if (lost_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, lost_);
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
    if (!(obj instanceof service.LeaderboardEntry)) {
      return super.equals(obj);
    }
    service.LeaderboardEntry other = (service.LeaderboardEntry) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (getRank()
        != other.getRank()) return false;
    if (getWins()
        != other.getWins()) return false;
    if (getLost()
        != other.getLost()) return false;
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + RANK_FIELD_NUMBER;
    hash = (53 * hash) + getRank();
    hash = (37 * hash) + WINS_FIELD_NUMBER;
    hash = (53 * hash) + getWins();
    hash = (37 * hash) + LOST_FIELD_NUMBER;
    hash = (53 * hash) + getLost();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.LeaderboardEntry parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.LeaderboardEntry parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.LeaderboardEntry parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.LeaderboardEntry parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.LeaderboardEntry parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.LeaderboardEntry parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.LeaderboardEntry parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.LeaderboardEntry parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.LeaderboardEntry parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.LeaderboardEntry parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.LeaderboardEntry parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.LeaderboardEntry parseFrom(
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
  public static Builder newBuilder(service.LeaderboardEntry prototype) {
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
   * One entry in the leaderboard
   * </pre>
   *
   * Protobuf type {@code services.LeaderboardEntry}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.LeaderboardEntry)
      service.LeaderboardEntryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.RockPaperScissorsProto.internal_static_services_LeaderboardEntry_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.RockPaperScissorsProto.internal_static_services_LeaderboardEntry_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.LeaderboardEntry.class, service.LeaderboardEntry.Builder.class);
    }

    // Construct using service.LeaderboardEntry.newBuilder()
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
      name_ = "";

      rank_ = 0;

      wins_ = 0;

      lost_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.RockPaperScissorsProto.internal_static_services_LeaderboardEntry_descriptor;
    }

    @java.lang.Override
    public service.LeaderboardEntry getDefaultInstanceForType() {
      return service.LeaderboardEntry.getDefaultInstance();
    }

    @java.lang.Override
    public service.LeaderboardEntry build() {
      service.LeaderboardEntry result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.LeaderboardEntry buildPartial() {
      service.LeaderboardEntry result = new service.LeaderboardEntry(this);
      result.name_ = name_;
      result.rank_ = rank_;
      result.wins_ = wins_;
      result.lost_ = lost_;
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
      if (other instanceof service.LeaderboardEntry) {
        return mergeFrom((service.LeaderboardEntry)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.LeaderboardEntry other) {
      if (other == service.LeaderboardEntry.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getRank() != 0) {
        setRank(other.getRank());
      }
      if (other.getWins() != 0) {
        setWins(other.getWins());
      }
      if (other.getLost() != 0) {
        setLost(other.getLost());
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
      service.LeaderboardEntry parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.LeaderboardEntry) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <pre>
     * name of player
     * </pre>
     *
     * <code>string name = 1;</code>
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
     * <pre>
     * name of player
     * </pre>
     *
     * <code>string name = 1;</code>
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
     * <pre>
     * name of player
     * </pre>
     *
     * <code>string name = 1;</code>
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
     * <pre>
     * name of player
     * </pre>
     *
     * <code>string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * name of player
     * </pre>
     *
     * <code>string name = 1;</code>
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

    private int rank_ ;
    /**
     * <pre>
     * you can rank any way you like, based only on wins or on diff between won and lost games or whatever you come up with 
     * </pre>
     *
     * <code>int32 rank = 2;</code>
     * @return The rank.
     */
    @java.lang.Override
    public int getRank() {
      return rank_;
    }
    /**
     * <pre>
     * you can rank any way you like, based only on wins or on diff between won and lost games or whatever you come up with 
     * </pre>
     *
     * <code>int32 rank = 2;</code>
     * @param value The rank to set.
     * @return This builder for chaining.
     */
    public Builder setRank(int value) {
      
      rank_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * you can rank any way you like, based only on wins or on diff between won and lost games or whatever you come up with 
     * </pre>
     *
     * <code>int32 rank = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRank() {
      
      rank_ = 0;
      onChanged();
      return this;
    }

    private int wins_ ;
    /**
     * <pre>
     * number of wins
     * </pre>
     *
     * <code>int32 wins = 3;</code>
     * @return The wins.
     */
    @java.lang.Override
    public int getWins() {
      return wins_;
    }
    /**
     * <pre>
     * number of wins
     * </pre>
     *
     * <code>int32 wins = 3;</code>
     * @param value The wins to set.
     * @return This builder for chaining.
     */
    public Builder setWins(int value) {
      
      wins_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * number of wins
     * </pre>
     *
     * <code>int32 wins = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearWins() {
      
      wins_ = 0;
      onChanged();
      return this;
    }

    private int lost_ ;
    /**
     * <pre>
     * number of lost games 
     * </pre>
     *
     * <code>int32 lost = 4;</code>
     * @return The lost.
     */
    @java.lang.Override
    public int getLost() {
      return lost_;
    }
    /**
     * <pre>
     * number of lost games 
     * </pre>
     *
     * <code>int32 lost = 4;</code>
     * @param value The lost to set.
     * @return This builder for chaining.
     */
    public Builder setLost(int value) {
      
      lost_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * number of lost games 
     * </pre>
     *
     * <code>int32 lost = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearLost() {
      
      lost_ = 0;
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


    // @@protoc_insertion_point(builder_scope:services.LeaderboardEntry)
  }

  // @@protoc_insertion_point(class_scope:services.LeaderboardEntry)
  private static final service.LeaderboardEntry DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.LeaderboardEntry();
  }

  public static service.LeaderboardEntry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LeaderboardEntry>
      PARSER = new com.google.protobuf.AbstractParser<LeaderboardEntry>() {
    @java.lang.Override
    public LeaderboardEntry parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LeaderboardEntry(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LeaderboardEntry> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LeaderboardEntry> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.LeaderboardEntry getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

