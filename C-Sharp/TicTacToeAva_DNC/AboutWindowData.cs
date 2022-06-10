using System;
using System.ComponentModel;
using System.Globalization;
using System.Reflection;
using System.Runtime.CompilerServices;
using System.Runtime.InteropServices;
using JetBrains.Annotations;

namespace TicTacToeAva_DNC
{
    public class AboutWindowData : INotifyPropertyChanged
    {
        public string TTitle { get; set; } =
            $"About {((AssemblyProductAttribute) Attribute.GetCustomAttribute(Assembly.GetExecutingAssembly(), typeof(AssemblyProductAttribute), false)).Product}";

        public string TAbout { get; set; } =
            $@"Designed by {((AssemblyCompanyAttribute) Attribute.GetCustomAttribute(Assembly.GetExecutingAssembly(), typeof(AssemblyCompanyAttribute), false))?.Company} in May 2022.
Version: {Assembly.GetExecutingAssembly().GetName().Version}
Description: {((AssemblyDescriptionAttribute) Attribute.GetCustomAttribute(Assembly.GetExecutingAssembly(), typeof(AssemblyDescriptionAttribute), false))?.Description}

OS: {RuntimeInformation.OSDescription} {RuntimeInformation.OSArchitecture} on {RuntimeInformation.ProcessArchitecture} CPU.
.NET version: {Environment.Version}
CLR version: {RuntimeEnvironment.GetSystemVersion()}
Timezone: {DateTime.Now:zzzz} {TimeZoneInfo.Local.StandardName}

Future expansions:
- Match import and viewer
- More accurate counter
- Lower memory usage
- Cross platform compatibility";

        public event PropertyChangedEventHandler? PropertyChanged;

        [NotifyPropertyChangedInvocator]
        private void OnPropertyChanged([CallerMemberName] string? propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}