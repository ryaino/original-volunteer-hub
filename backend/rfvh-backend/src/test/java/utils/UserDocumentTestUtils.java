package utils;

import java.util.ArrayList;
import java.util.List;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;

/**
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public class UserDocumentTestUtils {

    private List<UserDocument> documents;
    private UserDocument userDocument1;
    private UserDocument userDocument3;

    public UserDocumentTestUtils() {
        userDocument1 = new UserDocument("Ryan", "test@test.com", "111");
        userDocument3 = new UserDocument("Ryan", null, null);
        documents = new ArrayList<>();
        documents.add(userDocument1);
        documents.add(userDocument3);
    }

    public UserDocument getDocument() {
        return userDocument1;
    }

    public List<UserDocument> getList() {
        return documents;
    }

}
