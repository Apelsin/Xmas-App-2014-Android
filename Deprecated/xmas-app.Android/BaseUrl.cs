using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Xamarin.Forms;
using xmas_app;

[assembly: Dependency(typeof(xmas_app.Android.BaseUrl))]
namespace xmas_app.Android
{
    public class BaseUrl : IBaseUrl
    {
        public string Get()
        {
            return "file:///android_asset/";
        }
    }
}