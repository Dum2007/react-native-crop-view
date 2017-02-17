//
//  RCTCropViewManager.m
//  RCTCropView
//
//  Created by RanJun on 16/12/20.
//  Copyright © 2016年 RCTCropView. All rights reserved.
//

#import "RCTCropViewManager.h"
#import "CropView.h"

@implementation RCTCropViewManager

RCT_EXPORT_MODULE();

- (UIView *)view
{
    return [[CropView alloc] init];
}
RCT_EXPORT_VIEW_PROPERTY(shapeRadius, CGFloat);
RCT_EXPORT_VIEW_PROPERTY(isFillScreen, BOOL);
RCT_EXPORT_VIEW_PROPERTY(shapTop, CGFloat);
RCT_EXPORT_VIEW_PROPERTY(shapLeft, CGFloat);
RCT_EXPORT_VIEW_PROPERTY(shapOpacity, CGFloat);

@end
