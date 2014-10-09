using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using System.Diagnostics;

namespace xmas_app
{
    public class MainTabbedPages : TabbedPage
    {
        Page TabEvents = new EventSchedule() { Title = "Events", };
        Page TabInfo = new Page() { Title = "Info" };
        Page TabParkMap = new ParkMap() { Title = "Map" };
        Page TabAbout = new Page() { Title = "About" };
        IEnumerable<Page> AllTabs()
        {
            yield return TabEvents;
            yield return TabInfo;
            yield return TabParkMap;
            yield return TabAbout;
        }
        public MainTabbedPages():
            base()
        {
            Title = "Pages - Christmas in the Park";
            foreach (Page t in AllTabs())
                Children.Add(t);
            
        }
    }
}
