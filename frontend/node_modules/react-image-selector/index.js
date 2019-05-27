import React from 'react';
import ReactDOM from 'react-dom';

import { watchImage, addSource } from 'image-selector';

const keys = [
	'width',
	'aspectRatio',
	'src',
	'at2x'
];

export class Image extends React.Component {

	componentDidMount () {
		var cuts = this.props.children.map(child => {
			return keys.reduce((acc, prop) => {
				if (child.props[prop] !== undefined) {
					acc[prop] = child.props[prop];
				}
				return acc;
			}, {});
		});

		var img = ReactDOM.findDOMNode(this);
		if (this.props.responsive) {
			this.watcher = watchImage(img, cuts);
		} else {
			addSource(img, 'src', cuts);
		}
	}

	componentDidUpdate () {
		if (this.watcher) {
			this.watcher.recalculate();
		}
	}

	componentWillUnmount () {
		if (this.watcher) {
			this.watcher.destroy();
		}
	}

	render () {
		return (<img src={this.props.src} alt={this.props.alt} className={this.props.className || ''} />);
	}
}

export class Cut extends React.Component {
	render () {}
}
