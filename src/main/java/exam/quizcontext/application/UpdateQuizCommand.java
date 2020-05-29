package exam.quizcontext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateQuizCommand {

    private String question;
    private String answer;
}
