// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/password.proto

package service;

public interface SaveResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.SaveRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool ok = 1;</code>
   * @return The ok.
   */
  boolean getOk();

  /**
   * <pre>
   * only used if ok is false
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <pre>
   * only used if ok is false
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}
