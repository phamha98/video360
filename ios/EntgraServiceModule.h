//
//  EntgraServiceModule.h
//  video360
//
//  Created by Phạm Hà on 10/12/2023.
//

#ifndef EntgraServiceModule_h
#define EntgraServiceModule_h

#import <React/RCTBridgeModule.h>
@interface EntgraServiceModule : NSObject <RCTBridgeModule>
- (void) getDeviceId :(RCTResponseSenderBlock)successCallBack errorCallBack :(RCTResponseSenderBlock) errorCallBack;
- (void) getDeviceAttributes :(RCTResponseSenderBlock)successCallBack errorCallBack :(RCTResponseSenderBlock) errorCallBack;
@end


#endif /* EntgraServiceModule_h */
