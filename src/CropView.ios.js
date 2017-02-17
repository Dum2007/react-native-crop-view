/**
 * Created by RanJun on 16/12/20.
 */

import React, { Component, PropTypes , } from 'react';
import { requireNativeComponent,  UIManager} from 'react-native';
//console.log('UIManager====>>>>>', UIManager);
class CropView extends Component {
    render() {
        return (
            <NativeCropView
                {...this.props}
                style={[{
          backgroundColor: 'transparent',
        }, this.props.style
        ]}
            />
        );
    }
}

CropView.propTypes = {
    shapeRadius: PropTypes.number,
    isFillScreen : PropTypes.bool,
    shapTop: PropTypes.number,
    shapLeft: PropTypes.number,
    shapOpacity: PropTypes.number,
};
CropView.defaultProps={
    shapeRadius: 1,
    isFillScreen: true,
    shapTop: 0,
    shapLeft: 1,
    shapOpacity: 0.5
}

const NativeCropView = requireNativeComponent('RCTCropView', CropView);

module.exports = CropView;