'use strict';

Object.defineProperty(exports, "__esModule", {
	value: true
});
exports.Cut = exports.Image = undefined;

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _reactDom = require('react-dom');

var _reactDom2 = _interopRequireDefault(_reactDom);

var _imageSelector = require('image-selector');

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var keys = ['width', 'aspectRatio', 'src', 'at2x'];

var Image = exports.Image = function (_React$Component) {
	_inherits(Image, _React$Component);

	function Image() {
		_classCallCheck(this, Image);

		return _possibleConstructorReturn(this, (Image.__proto__ || Object.getPrototypeOf(Image)).apply(this, arguments));
	}

	_createClass(Image, [{
		key: 'componentDidMount',
		value: function componentDidMount() {
			var cuts = this.props.children.map(function (child) {
				return keys.reduce(function (acc, prop) {
					if (child.props[prop] !== undefined) {
						acc[prop] = child.props[prop];
					}
					return acc;
				}, {});
			});

			var img = _reactDom2.default.findDOMNode(this);
			if (this.props.responsive) {
				this.watcher = (0, _imageSelector.watchImage)(img, cuts);
			} else {
				(0, _imageSelector.addSource)(img, 'src', cuts);
			}
		}
	}, {
		key: 'componentDidUpdate',
		value: function componentDidUpdate() {
			if (this.watcher) {
				this.watcher.recalculate();
			}
		}
	}, {
		key: 'componentWillUnmount',
		value: function componentWillUnmount() {
			if (this.watcher) {
				this.watcher.destroy();
			}
		}
	}, {
		key: 'render',
		value: function render() {
			return _react2.default.createElement('img', { src: this.props.src, alt: this.props.alt, className: this.props.className || '' });
		}
	}]);

	return Image;
}(_react2.default.Component);

var Cut = exports.Cut = function (_React$Component2) {
	_inherits(Cut, _React$Component2);

	function Cut() {
		_classCallCheck(this, Cut);

		return _possibleConstructorReturn(this, (Cut.__proto__ || Object.getPrototypeOf(Cut)).apply(this, arguments));
	}

	_createClass(Cut, [{
		key: 'render',
		value: function render() {}
	}]);

	return Cut;
}(_react2.default.Component);