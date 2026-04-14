package com.example.Kraken_C2.Cli;

import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;
import org.jline.utils.AttributedString;

@Configuration
public class SpringShellConfiguration implements PromptProvider {
    @Override
    public final AttributedString getPrompt() {
        return new AttributedString("Kraken > ");
    }

}

