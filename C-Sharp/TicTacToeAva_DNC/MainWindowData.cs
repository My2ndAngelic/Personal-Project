using System.Collections.ObjectModel;
using System.ComponentModel;

namespace TicTacToeAva_DNC
{
    public sealed class MainWindowData : INotifyPropertyChanged
    {
        public MainWindowData()
        {
            TListMoveHistory = new ObservableCollection<string>();
        }

        public ObservableCollection<string> TListMoveHistory { get; }

        public event PropertyChangedEventHandler? PropertyChanged;
    }
}