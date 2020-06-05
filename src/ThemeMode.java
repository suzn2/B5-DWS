public class ThemeMode {
    int theme_index = 0;
    Theme[] themes = new Theme[8];
    Segment segment = new Segment();

    void initThemeMode() {

    }

    void nextTheme() {
        if(theme_index > -1 && theme_index < themes.length) theme_index++;
        else if(theme_index == themes.length) theme_index = 0;
    }

    void prevTheme() {
        if(theme_index > -1 && theme_index < themes.length) theme_index--;
        else if(theme_index == -1) theme_index = themes.length - 1;
    }

    void decideTheme() {
        syncUiWithTheme(themes[theme_index]);
    }

    void syncUiWithTheme(Theme theme) {
        segment.setTextColor(theme.text);
        segment.setBackgroundColor(theme.background);
    }

}
