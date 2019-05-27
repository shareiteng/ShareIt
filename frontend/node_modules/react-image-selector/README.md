# react-image-selector

This is a React component that wraps the [imageSelector](https://github.com/stutrek/imageSelector). It takes a set of cuts of images and fills in the src attribute of an image based on the size of the image.

## Basic Usage

The Image component creates an &lt;img&gt;. The Cuts component never render, they hold data about the different cuts of the image.

```javascript
import { Image, Cut } from 'react-image-selector';

export default MyImage extends React.Component {
	render () {
		return (<Image responsive={true}>
			<Cut
				width={200}
				height={400}
				src="/path/to/image.jpg"
				at2x="/path/to/retina/image.jpg"
			/>
			<Cut
				width={400}
				height={800}
				src="/path/to/image.jpg"
				at2x="/path/to/retina/image.jpg"
			/>
		</Image>)
	}
}
```
