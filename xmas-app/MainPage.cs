using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace xmas_app
{
    class MainPage : ContentPage
    {
        MainTabbedPages TabbedPages = new MainTabbedPages();
        public MainPage()
        {
            Title = "Home - Christmas in the Park";
            var button =  new Button() { Text = "Go to Tabs", };
            button.Clicked += button_Clicked;
            var grid = new Grid();
            grid.Children.Add(button);
            Content = grid;
        }

        void button_Clicked(object sender, EventArgs e)
        {
            ((NavigationPage)Parent).PushAsync(TabbedPages);
        }
    }
}
