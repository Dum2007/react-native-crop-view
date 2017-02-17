/**
 * Created by RanJun on 16/12/20.
 */

import React, { Component, PropTypes} from 'react';
import {View, requireNativeComponent, PixelRatio} from 'react-native';
class CropView extends Component {
    // 构造
    render() {
        //console.log('NativeCropView======>>>>>', NativeCropView);
        return (
            <NativeCropView
                {...this.props}
            />
        );
    }
}

CropView.propTypes = {
    ...View.propTypes,
    shapeRadius: PropTypes.number,
    //isFillScreen : PropTypes.bool,
    shapTop: PropTypes.number,
    shapLeft: PropTypes.number,
    overlayColor: PropTypes.string,
};
CropView.defaultProps={
    shapeRadius: 50,
    //isFillScreen: true,
    shapTop: 0,
    shapLeft: 0,
    overlayColor: '#00000050'
}

const NativeCropView = requireNativeComponent('CropView', CropView);

module.exports = CropView;