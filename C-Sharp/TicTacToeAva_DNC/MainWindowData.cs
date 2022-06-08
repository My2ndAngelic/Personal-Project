using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using JetBrains.Annotations;

namespace TicTacToeAva_DNC
{
    public sealed class MainWindowData : INotifyPropertyChanged
    {
        public ObservableCollection<string> TListMoveHistory { get; }

        public MainWindowData()
        {
            TListMoveHistory = new ObservableCollection<string>();
        }

        public event PropertyChangedEventHandler? PropertyChanged;

        [NotifyPropertyChangedInvocator]
        private void OnPropertyChanged([CallerMemberName] string? propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}