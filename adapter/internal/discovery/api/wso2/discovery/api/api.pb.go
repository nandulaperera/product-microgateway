// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.25.0
// 	protoc        v3.14.0
// source: wso2/discovery/api/api.proto

package api

import (
	proto "github.com/golang/protobuf/proto"
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

// This is a compile-time assertion that a sufficiently up-to-date version
// of the legacy proto package is being used.
const _ = proto.ProtoPackageIsVersion4

// API config model
type Api struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Id                  string            `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	Title               string            `protobuf:"bytes,2,opt,name=title,proto3" json:"title,omitempty"`
	Version             string            `protobuf:"bytes,3,opt,name=version,proto3" json:"version,omitempty"`
	ApiType             string            `protobuf:"bytes,4,opt,name=apiType,proto3" json:"apiType,omitempty"`
	Description         string            `protobuf:"bytes,5,opt,name=description,proto3" json:"description,omitempty"`
	ProductionUrls      []*Endpoint       `protobuf:"bytes,6,rep,name=productionUrls,proto3" json:"productionUrls,omitempty"`
	SandboxUrls         []*Endpoint       `protobuf:"bytes,7,rep,name=sandboxUrls,proto3" json:"sandboxUrls,omitempty"`
	Resources           []*Resource       `protobuf:"bytes,8,rep,name=resources,proto3" json:"resources,omitempty"`
	BasePath            string            `protobuf:"bytes,9,opt,name=basePath,proto3" json:"basePath,omitempty"`
	Tier                string            `protobuf:"bytes,10,opt,name=tier,proto3" json:"tier,omitempty"`
	ApiLifeCycleState   string            `protobuf:"bytes,11,opt,name=apiLifeCycleState,proto3" json:"apiLifeCycleState,omitempty"`
	SecurityScheme      []string          `protobuf:"bytes,12,rep,name=securityScheme,proto3" json:"securityScheme,omitempty"`
	EndpointSecurity    *EndpointSecurity `protobuf:"bytes,13,opt,name=endpointSecurity,proto3" json:"endpointSecurity,omitempty"`
	AuthorizationHeader string            `protobuf:"bytes,14,opt,name=authorizationHeader,proto3" json:"authorizationHeader,omitempty"`
	DisableSecurity     bool              `protobuf:"varint,15,opt,name=disableSecurity,proto3" json:"disableSecurity,omitempty"`
}

func (x *Api) Reset() {
	*x = Api{}
	if protoimpl.UnsafeEnabled {
		mi := &file_wso2_discovery_api_api_proto_msgTypes[0]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *Api) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*Api) ProtoMessage() {}

func (x *Api) ProtoReflect() protoreflect.Message {
	mi := &file_wso2_discovery_api_api_proto_msgTypes[0]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use Api.ProtoReflect.Descriptor instead.
func (*Api) Descriptor() ([]byte, []int) {
	return file_wso2_discovery_api_api_proto_rawDescGZIP(), []int{0}
}

func (x *Api) GetId() string {
	if x != nil {
		return x.Id
	}
	return ""
}

func (x *Api) GetTitle() string {
	if x != nil {
		return x.Title
	}
	return ""
}

func (x *Api) GetVersion() string {
	if x != nil {
		return x.Version
	}
	return ""
}

func (x *Api) GetApiType() string {
	if x != nil {
		return x.ApiType
	}
	return ""
}

func (x *Api) GetDescription() string {
	if x != nil {
		return x.Description
	}
	return ""
}

func (x *Api) GetProductionUrls() []*Endpoint {
	if x != nil {
		return x.ProductionUrls
	}
	return nil
}

func (x *Api) GetSandboxUrls() []*Endpoint {
	if x != nil {
		return x.SandboxUrls
	}
	return nil
}

func (x *Api) GetResources() []*Resource {
	if x != nil {
		return x.Resources
	}
	return nil
}

func (x *Api) GetBasePath() string {
	if x != nil {
		return x.BasePath
	}
	return ""
}

func (x *Api) GetTier() string {
	if x != nil {
		return x.Tier
	}
	return ""
}

func (x *Api) GetApiLifeCycleState() string {
	if x != nil {
		return x.ApiLifeCycleState
	}
	return ""
}

func (x *Api) GetSecurityScheme() []string {
	if x != nil {
		return x.SecurityScheme
	}
	return nil
}

func (x *Api) GetEndpointSecurity() *EndpointSecurity {
	if x != nil {
		return x.EndpointSecurity
	}
	return nil
}

func (x *Api) GetAuthorizationHeader() string {
	if x != nil {
		return x.AuthorizationHeader
	}
	return ""
}

func (x *Api) GetDisableSecurity() bool {
	if x != nil {
		return x.DisableSecurity
	}
	return false
}

var File_wso2_discovery_api_api_proto protoreflect.FileDescriptor

var file_wso2_discovery_api_api_proto_rawDesc = []byte{
	0x0a, 0x1c, 0x77, 0x73, 0x6f, 0x32, 0x2f, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65, 0x72, 0x79,
	0x2f, 0x61, 0x70, 0x69, 0x2f, 0x61, 0x70, 0x69, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x12,
	0x77, 0x73, 0x6f, 0x32, 0x2e, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65, 0x72, 0x79, 0x2e, 0x61,
	0x70, 0x69, 0x1a, 0x21, 0x77, 0x73, 0x6f, 0x32, 0x2f, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65,
	0x72, 0x79, 0x2f, 0x61, 0x70, 0x69, 0x2f, 0x45, 0x6e, 0x64, 0x70, 0x6f, 0x69, 0x6e, 0x74, 0x2e,
	0x70, 0x72, 0x6f, 0x74, 0x6f, 0x1a, 0x21, 0x77, 0x73, 0x6f, 0x32, 0x2f, 0x64, 0x69, 0x73, 0x63,
	0x6f, 0x76, 0x65, 0x72, 0x79, 0x2f, 0x61, 0x70, 0x69, 0x2f, 0x52, 0x65, 0x73, 0x6f, 0x75, 0x72,
	0x63, 0x65, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x1a, 0x2a, 0x77, 0x73, 0x6f, 0x32, 0x2f, 0x64,
	0x69, 0x73, 0x63, 0x6f, 0x76, 0x65, 0x72, 0x79, 0x2f, 0x61, 0x70, 0x69, 0x2f, 0x65, 0x6e, 0x64,
	0x70, 0x6f, 0x69, 0x6e, 0x74, 0x5f, 0x73, 0x65, 0x63, 0x75, 0x72, 0x69, 0x74, 0x79, 0x2e, 0x70,
	0x72, 0x6f, 0x74, 0x6f, 0x22, 0xf7, 0x04, 0x0a, 0x03, 0x41, 0x70, 0x69, 0x12, 0x0e, 0x0a, 0x02,
	0x69, 0x64, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x02, 0x69, 0x64, 0x12, 0x14, 0x0a, 0x05,
	0x74, 0x69, 0x74, 0x6c, 0x65, 0x18, 0x02, 0x20, 0x01, 0x28, 0x09, 0x52, 0x05, 0x74, 0x69, 0x74,
	0x6c, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x76, 0x65, 0x72, 0x73, 0x69, 0x6f, 0x6e, 0x18, 0x03, 0x20,
	0x01, 0x28, 0x09, 0x52, 0x07, 0x76, 0x65, 0x72, 0x73, 0x69, 0x6f, 0x6e, 0x12, 0x18, 0x0a, 0x07,
	0x61, 0x70, 0x69, 0x54, 0x79, 0x70, 0x65, 0x18, 0x04, 0x20, 0x01, 0x28, 0x09, 0x52, 0x07, 0x61,
	0x70, 0x69, 0x54, 0x79, 0x70, 0x65, 0x12, 0x20, 0x0a, 0x0b, 0x64, 0x65, 0x73, 0x63, 0x72, 0x69,
	0x70, 0x74, 0x69, 0x6f, 0x6e, 0x18, 0x05, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0b, 0x64, 0x65, 0x73,
	0x63, 0x72, 0x69, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x12, 0x44, 0x0a, 0x0e, 0x70, 0x72, 0x6f, 0x64,
	0x75, 0x63, 0x74, 0x69, 0x6f, 0x6e, 0x55, 0x72, 0x6c, 0x73, 0x18, 0x06, 0x20, 0x03, 0x28, 0x0b,
	0x32, 0x1c, 0x2e, 0x77, 0x73, 0x6f, 0x32, 0x2e, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65, 0x72,
	0x79, 0x2e, 0x61, 0x70, 0x69, 0x2e, 0x45, 0x6e, 0x64, 0x70, 0x6f, 0x69, 0x6e, 0x74, 0x52, 0x0e,
	0x70, 0x72, 0x6f, 0x64, 0x75, 0x63, 0x74, 0x69, 0x6f, 0x6e, 0x55, 0x72, 0x6c, 0x73, 0x12, 0x3e,
	0x0a, 0x0b, 0x73, 0x61, 0x6e, 0x64, 0x62, 0x6f, 0x78, 0x55, 0x72, 0x6c, 0x73, 0x18, 0x07, 0x20,
	0x03, 0x28, 0x0b, 0x32, 0x1c, 0x2e, 0x77, 0x73, 0x6f, 0x32, 0x2e, 0x64, 0x69, 0x73, 0x63, 0x6f,
	0x76, 0x65, 0x72, 0x79, 0x2e, 0x61, 0x70, 0x69, 0x2e, 0x45, 0x6e, 0x64, 0x70, 0x6f, 0x69, 0x6e,
	0x74, 0x52, 0x0b, 0x73, 0x61, 0x6e, 0x64, 0x62, 0x6f, 0x78, 0x55, 0x72, 0x6c, 0x73, 0x12, 0x3a,
	0x0a, 0x09, 0x72, 0x65, 0x73, 0x6f, 0x75, 0x72, 0x63, 0x65, 0x73, 0x18, 0x08, 0x20, 0x03, 0x28,
	0x0b, 0x32, 0x1c, 0x2e, 0x77, 0x73, 0x6f, 0x32, 0x2e, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65,
	0x72, 0x79, 0x2e, 0x61, 0x70, 0x69, 0x2e, 0x52, 0x65, 0x73, 0x6f, 0x75, 0x72, 0x63, 0x65, 0x52,
	0x09, 0x72, 0x65, 0x73, 0x6f, 0x75, 0x72, 0x63, 0x65, 0x73, 0x12, 0x1a, 0x0a, 0x08, 0x62, 0x61,
	0x73, 0x65, 0x50, 0x61, 0x74, 0x68, 0x18, 0x09, 0x20, 0x01, 0x28, 0x09, 0x52, 0x08, 0x62, 0x61,
	0x73, 0x65, 0x50, 0x61, 0x74, 0x68, 0x12, 0x12, 0x0a, 0x04, 0x74, 0x69, 0x65, 0x72, 0x18, 0x0a,
	0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x74, 0x69, 0x65, 0x72, 0x12, 0x2c, 0x0a, 0x11, 0x61, 0x70,
	0x69, 0x4c, 0x69, 0x66, 0x65, 0x43, 0x79, 0x63, 0x6c, 0x65, 0x53, 0x74, 0x61, 0x74, 0x65, 0x18,
	0x0b, 0x20, 0x01, 0x28, 0x09, 0x52, 0x11, 0x61, 0x70, 0x69, 0x4c, 0x69, 0x66, 0x65, 0x43, 0x79,
	0x63, 0x6c, 0x65, 0x53, 0x74, 0x61, 0x74, 0x65, 0x12, 0x26, 0x0a, 0x0e, 0x73, 0x65, 0x63, 0x75,
	0x72, 0x69, 0x74, 0x79, 0x53, 0x63, 0x68, 0x65, 0x6d, 0x65, 0x18, 0x0c, 0x20, 0x03, 0x28, 0x09,
	0x52, 0x0e, 0x73, 0x65, 0x63, 0x75, 0x72, 0x69, 0x74, 0x79, 0x53, 0x63, 0x68, 0x65, 0x6d, 0x65,
	0x12, 0x50, 0x0a, 0x10, 0x65, 0x6e, 0x64, 0x70, 0x6f, 0x69, 0x6e, 0x74, 0x53, 0x65, 0x63, 0x75,
	0x72, 0x69, 0x74, 0x79, 0x18, 0x0d, 0x20, 0x01, 0x28, 0x0b, 0x32, 0x24, 0x2e, 0x77, 0x73, 0x6f,
	0x32, 0x2e, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65, 0x72, 0x79, 0x2e, 0x61, 0x70, 0x69, 0x2e,
	0x45, 0x6e, 0x64, 0x70, 0x6f, 0x69, 0x6e, 0x74, 0x53, 0x65, 0x63, 0x75, 0x72, 0x69, 0x74, 0x79,
	0x52, 0x10, 0x65, 0x6e, 0x64, 0x70, 0x6f, 0x69, 0x6e, 0x74, 0x53, 0x65, 0x63, 0x75, 0x72, 0x69,
	0x74, 0x79, 0x12, 0x30, 0x0a, 0x13, 0x61, 0x75, 0x74, 0x68, 0x6f, 0x72, 0x69, 0x7a, 0x61, 0x74,
	0x69, 0x6f, 0x6e, 0x48, 0x65, 0x61, 0x64, 0x65, 0x72, 0x18, 0x0e, 0x20, 0x01, 0x28, 0x09, 0x52,
	0x13, 0x61, 0x75, 0x74, 0x68, 0x6f, 0x72, 0x69, 0x7a, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x48, 0x65,
	0x61, 0x64, 0x65, 0x72, 0x12, 0x28, 0x0a, 0x0f, 0x64, 0x69, 0x73, 0x61, 0x62, 0x6c, 0x65, 0x53,
	0x65, 0x63, 0x75, 0x72, 0x69, 0x74, 0x79, 0x18, 0x0f, 0x20, 0x01, 0x28, 0x08, 0x52, 0x0f, 0x64,
	0x69, 0x73, 0x61, 0x62, 0x6c, 0x65, 0x53, 0x65, 0x63, 0x75, 0x72, 0x69, 0x74, 0x79, 0x42, 0x6b,
	0x0a, 0x1e, 0x6f, 0x72, 0x67, 0x2e, 0x77, 0x73, 0x6f, 0x32, 0x2e, 0x67, 0x61, 0x74, 0x65, 0x77,
	0x61, 0x79, 0x2e, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76, 0x65, 0x72, 0x79, 0x2e, 0x61, 0x70, 0x69,
	0x42, 0x08, 0x41, 0x70, 0x69, 0x50, 0x72, 0x6f, 0x74, 0x6f, 0x50, 0x01, 0x5a, 0x3d, 0x67, 0x69,
	0x74, 0x68, 0x75, 0x62, 0x2e, 0x63, 0x6f, 0x6d, 0x2f, 0x65, 0x6e, 0x76, 0x6f, 0x79, 0x70, 0x72,
	0x6f, 0x78, 0x79, 0x2f, 0x67, 0x6f, 0x2d, 0x63, 0x6f, 0x6e, 0x74, 0x72, 0x6f, 0x6c, 0x2d, 0x70,
	0x6c, 0x61, 0x6e, 0x65, 0x2f, 0x77, 0x73, 0x6f, 0x32, 0x2f, 0x64, 0x69, 0x73, 0x63, 0x6f, 0x76,
	0x65, 0x72, 0x79, 0x2f, 0x61, 0x70, 0x69, 0x3b, 0x61, 0x70, 0x69, 0x62, 0x06, 0x70, 0x72, 0x6f,
	0x74, 0x6f, 0x33,
}

var (
	file_wso2_discovery_api_api_proto_rawDescOnce sync.Once
	file_wso2_discovery_api_api_proto_rawDescData = file_wso2_discovery_api_api_proto_rawDesc
)

func file_wso2_discovery_api_api_proto_rawDescGZIP() []byte {
	file_wso2_discovery_api_api_proto_rawDescOnce.Do(func() {
		file_wso2_discovery_api_api_proto_rawDescData = protoimpl.X.CompressGZIP(file_wso2_discovery_api_api_proto_rawDescData)
	})
	return file_wso2_discovery_api_api_proto_rawDescData
}

var file_wso2_discovery_api_api_proto_msgTypes = make([]protoimpl.MessageInfo, 1)
var file_wso2_discovery_api_api_proto_goTypes = []interface{}{
	(*Api)(nil),              // 0: wso2.discovery.api.Api
	(*Endpoint)(nil),         // 1: wso2.discovery.api.Endpoint
	(*Resource)(nil),         // 2: wso2.discovery.api.Resource
	(*EndpointSecurity)(nil), // 3: wso2.discovery.api.EndpointSecurity
}
var file_wso2_discovery_api_api_proto_depIdxs = []int32{
	1, // 0: wso2.discovery.api.Api.productionUrls:type_name -> wso2.discovery.api.Endpoint
	1, // 1: wso2.discovery.api.Api.sandboxUrls:type_name -> wso2.discovery.api.Endpoint
	2, // 2: wso2.discovery.api.Api.resources:type_name -> wso2.discovery.api.Resource
	3, // 3: wso2.discovery.api.Api.endpointSecurity:type_name -> wso2.discovery.api.EndpointSecurity
	4, // [4:4] is the sub-list for method output_type
	4, // [4:4] is the sub-list for method input_type
	4, // [4:4] is the sub-list for extension type_name
	4, // [4:4] is the sub-list for extension extendee
	0, // [0:4] is the sub-list for field type_name
}

func init() { file_wso2_discovery_api_api_proto_init() }
func file_wso2_discovery_api_api_proto_init() {
	if File_wso2_discovery_api_api_proto != nil {
		return
	}
	file_wso2_discovery_api_Endpoint_proto_init()
	file_wso2_discovery_api_Resource_proto_init()
	file_wso2_discovery_api_endpoint_security_proto_init()
	if !protoimpl.UnsafeEnabled {
		file_wso2_discovery_api_api_proto_msgTypes[0].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*Api); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
	}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_wso2_discovery_api_api_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   1,
			NumExtensions: 0,
			NumServices:   0,
		},
		GoTypes:           file_wso2_discovery_api_api_proto_goTypes,
		DependencyIndexes: file_wso2_discovery_api_api_proto_depIdxs,
		MessageInfos:      file_wso2_discovery_api_api_proto_msgTypes,
	}.Build()
	File_wso2_discovery_api_api_proto = out.File
	file_wso2_discovery_api_api_proto_rawDesc = nil
	file_wso2_discovery_api_api_proto_goTypes = nil
	file_wso2_discovery_api_api_proto_depIdxs = nil
}
