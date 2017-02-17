//
//  RCTCropView.m
//  RCTCropView
//
//  Created by RanJun on 16/12/20.
//  Copyright © 2016年 RCTCropView. All rights reserved.
//

#import "CropView.h"
@implementation CropView {
    CAShapeLayer *_shapLayer;
    CGFloat _radius;
    BOOL _isFillScreen;
    CGFloat _shapTop;
    CGFloat _shapLeft;
    CGFloat _shapOpacity;
}
- (void)setShapOpacity:(CGFloat)shapOpacity
{
    _shapOpacity = shapOpacity;
    if (_shapLayer) {
        [_shapLayer removeFromSuperlayer];
    }
    _shapLayer = [CAShapeLayer layer];
    _shapLayer.fillRule = kCAFillRuleEvenOdd;
    _shapLayer.fillColor = [[UIColor blackColor] CGColor];
}
- (void)setIsFillScreen:(BOOL)isFillScreen
{
    _isFillScreen = isFillScreen;
    if (_shapLayer) {
        [_shapLayer removeFromSuperlayer];
    }
    _shapLayer = [CAShapeLayer layer];
    _shapLayer.fillRule = kCAFillRuleEvenOdd;
    _shapLayer.fillColor = [[UIColor blackColor] CGColor];
}
- (void)setShapTop:(CGFloat)shapTop {
    _shapTop = shapTop;
    if (_shapLayer) {
        [_shapLayer removeFromSuperlayer];
    }
    _shapLayer = [CAShapeLayer layer];
    _shapLayer.fillRule = kCAFillRuleEvenOdd;
    _shapLayer.fillColor = [[UIColor blackColor] CGColor];
}
- (void)setShapLeft:(CGFloat)shapLeft {
    _shapLeft = shapLeft;
    if (_shapLayer) {
        [_shapLayer removeFromSuperlayer];
    }
    _shapLayer = [CAShapeLayer layer];
    _shapLayer.fillRule = kCAFillRuleEvenOdd;
    _shapLayer.fillColor = [[UIColor blackColor] CGColor];
}
- (void)setShapeRadius:(CGFloat)shapeRadius
{
    _radius = shapeRadius;
    if (_shapLayer) {
        [_shapLayer removeFromSuperlayer];
    }
    _shapLayer = [CAShapeLayer layer];
    _shapLayer.fillRule = kCAFillRuleEvenOdd;
    _shapLayer.fillColor = [[UIColor blackColor] CGColor];
}
-(void)layoutSubviews
{
    [super layoutSubviews];
    
    UIBezierPath *path;
    if (_isFillScreen) {
        path = [UIBezierPath bezierPathWithRect:[UIScreen mainScreen].bounds];
        [path appendPath:[UIBezierPath bezierPathWithArcCenter:CGPointMake(_radius+_shapLeft, _radius+_shapTop) radius:_radius startAngle:0 endAngle: 2 * M_PI clockwise:NO]];
    }
    else {
        path = [UIBezierPath bezierPathWithRect:self.frame];
        [path appendPath:[UIBezierPath bezierPathWithArcCenter:CGPointMake(self.frame.size.width*0.5, self.frame.size.height*0.5) radius:_radius startAngle:0 endAngle: 2 * M_PI clockwise:NO]];
    }
    
    
    _shapLayer.path = path.CGPath;
    _shapLayer.opacity = _shapOpacity;

    [self.layer addSublayer:_shapLayer];
}

@end
