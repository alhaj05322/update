package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/pingaddress.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AddressPingGrpc {

  private AddressPingGrpc() {}

  public static final String SERVICE_NAME = "services.AddressPing";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.PingAdressReq,
      service.PingAdressRes> getPingAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pingAddress",
      requestType = service.PingAdressReq.class,
      responseType = service.PingAdressRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.PingAdressReq,
      service.PingAdressRes> getPingAddressMethod() {
    io.grpc.MethodDescriptor<service.PingAdressReq, service.PingAdressRes> getPingAddressMethod;
    if ((getPingAddressMethod = AddressPingGrpc.getPingAddressMethod) == null) {
      synchronized (AddressPingGrpc.class) {
        if ((getPingAddressMethod = AddressPingGrpc.getPingAddressMethod) == null) {
          AddressPingGrpc.getPingAddressMethod = getPingAddressMethod =
              io.grpc.MethodDescriptor.<service.PingAdressReq, service.PingAdressRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "pingAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PingAdressReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PingAdressRes.getDefaultInstance()))
              .setSchemaDescriptor(new AddressPingMethodDescriptorSupplier("pingAddress"))
              .build();
        }
      }
    }
    return getPingAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.PingSerchReq,
      service.PingSerchRes> getGetIpAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getIpAddress",
      requestType = service.PingSerchReq.class,
      responseType = service.PingSerchRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.PingSerchReq,
      service.PingSerchRes> getGetIpAddressMethod() {
    io.grpc.MethodDescriptor<service.PingSerchReq, service.PingSerchRes> getGetIpAddressMethod;
    if ((getGetIpAddressMethod = AddressPingGrpc.getGetIpAddressMethod) == null) {
      synchronized (AddressPingGrpc.class) {
        if ((getGetIpAddressMethod = AddressPingGrpc.getGetIpAddressMethod) == null) {
          AddressPingGrpc.getGetIpAddressMethod = getGetIpAddressMethod =
              io.grpc.MethodDescriptor.<service.PingSerchReq, service.PingSerchRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getIpAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PingSerchReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PingSerchRes.getDefaultInstance()))
              .setSchemaDescriptor(new AddressPingMethodDescriptorSupplier("getIpAddress"))
              .build();
        }
      }
    }
    return getGetIpAddressMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddressPingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressPingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressPingStub>() {
        @java.lang.Override
        public AddressPingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressPingStub(channel, callOptions);
        }
      };
    return AddressPingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddressPingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressPingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressPingBlockingStub>() {
        @java.lang.Override
        public AddressPingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressPingBlockingStub(channel, callOptions);
        }
      };
    return AddressPingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddressPingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressPingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressPingFutureStub>() {
        @java.lang.Override
        public AddressPingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressPingFutureStub(channel, callOptions);
        }
      };
    return AddressPingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AddressPingImplBase implements io.grpc.BindableService {

    /**
     */
    public void pingAddress(service.PingAdressReq request,
        io.grpc.stub.StreamObserver<service.PingAdressRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingAddressMethod(), responseObserver);
    }

    /**
     */
    public void getIpAddress(service.PingSerchReq request,
        io.grpc.stub.StreamObserver<service.PingSerchRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIpAddressMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPingAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.PingAdressReq,
                service.PingAdressRes>(
                  this, METHODID_PING_ADDRESS)))
          .addMethod(
            getGetIpAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.PingSerchReq,
                service.PingSerchRes>(
                  this, METHODID_GET_IP_ADDRESS)))
          .build();
    }
  }

  /**
   */
  public static final class AddressPingStub extends io.grpc.stub.AbstractAsyncStub<AddressPingStub> {
    private AddressPingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressPingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressPingStub(channel, callOptions);
    }

    /**
     */
    public void pingAddress(service.PingAdressReq request,
        io.grpc.stub.StreamObserver<service.PingAdressRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIpAddress(service.PingSerchReq request,
        io.grpc.stub.StreamObserver<service.PingSerchRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIpAddressMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AddressPingBlockingStub extends io.grpc.stub.AbstractBlockingStub<AddressPingBlockingStub> {
    private AddressPingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressPingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressPingBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.PingAdressRes pingAddress(service.PingAdressReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.PingSerchRes getIpAddress(service.PingSerchReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIpAddressMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AddressPingFutureStub extends io.grpc.stub.AbstractFutureStub<AddressPingFutureStub> {
    private AddressPingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressPingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressPingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.PingAdressRes> pingAddress(
        service.PingAdressReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingAddressMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.PingSerchRes> getIpAddress(
        service.PingSerchReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIpAddressMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING_ADDRESS = 0;
  private static final int METHODID_GET_IP_ADDRESS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AddressPingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AddressPingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING_ADDRESS:
          serviceImpl.pingAddress((service.PingAdressReq) request,
              (io.grpc.stub.StreamObserver<service.PingAdressRes>) responseObserver);
          break;
        case METHODID_GET_IP_ADDRESS:
          serviceImpl.getIpAddress((service.PingSerchReq) request,
              (io.grpc.stub.StreamObserver<service.PingSerchRes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AddressPingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddressPingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.AddressPingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AddressPing");
    }
  }

  private static final class AddressPingFileDescriptorSupplier
      extends AddressPingBaseDescriptorSupplier {
    AddressPingFileDescriptorSupplier() {}
  }

  private static final class AddressPingMethodDescriptorSupplier
      extends AddressPingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddressPingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AddressPingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddressPingFileDescriptorSupplier())
              .addMethod(getPingAddressMethod())
              .addMethod(getGetIpAddressMethod())
              .build();
        }
      }
    }
    return result;
  }
}
