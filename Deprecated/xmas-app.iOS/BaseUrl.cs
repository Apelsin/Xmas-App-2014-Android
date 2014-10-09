using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using MonoTouch.Foundation;
using MonoTouch.UIKit;

using Xamarin.Forms;

[assembly: Dependency(typeof(xmas_app.iOS.BaseUrl))]
namespace xmas_app.iOS
{
    public class BaseUrl : IBaseUrl
    {
        public string Get()
        {
            return NSBundle.MainBundle.BundlePath;
        }
    }
}