using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace xmas_app
{
    class ParkMap : ContentPage
    {
        public ParkMap()
        {
            // URL string uses base URL from Dependency Service
            String html = DependencyService.Get<IBaseUrl>().Get() + "park-map.html";
            // New WebView with source set to the park map HTML file
            WebView browser = new WebView() { Source = html };
            // Update this page's content
            Content = browser;
        }
    }
}
