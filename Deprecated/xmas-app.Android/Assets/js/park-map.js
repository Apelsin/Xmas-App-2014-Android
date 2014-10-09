var myScroll;
var image;
var loading;
var minimap;

function imgReady() {
    loading.style.left = '-99999px';
}

function loaded() {
    image = document.getElementById('MapImage');
    minimap = document.getElementById('minimap');

    myScroll = new IScroll('#wrapper', {
        zoom: true,
        zoomMin: 1,
        zoomMax: 5,
        scrollX: true,
        scrollY: true,
        mouseWheel: true,
        freeScroll: true,
        wheelAction: 'zoom',
        indicators: {
            el: document.getElementById('minimap'),
            resize: false,
            interactive: true
        }
    });

    myScroll.on('zoomStart', function () {
        minimap.style.left = '-99999px';
    });

    myScroll.on('zoomEnd', function ()
    {
        if (this.scale > 2) {
            minimap.style.left = '10px';
        } else {
            minimap.style.left = '-99999px';
        }

        //if (image.getAttribute('src') !== newImg) {
        //    image.src = newImg;
        //    loading.style.left = '50%';
        //}
    });
}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);