using Avalonia;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Markup.Xaml;

namespace TicTacToeAva_DNC
{
    public partial class AboutWindow : Window
    {
        public AboutWindow()
        {
            InitializeComponent();
#if DEBUG
            this.AttachDevTools();
#endif
            DataContext = new AboutWindowData();
        }

        private void ButtonOK_OnClick(object? sender, RoutedEventArgs e)
        {
            Close();
        }

        private void InitializeComponent()
        {
            AvaloniaXamlLoader.Load(this);
        }
    }
}