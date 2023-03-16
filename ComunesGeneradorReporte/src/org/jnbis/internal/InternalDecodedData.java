package org.jnbis.internal;

import java.util.HashMap;
import java.util.Set;
import org.jnbis.DecodedData;
import org.jnbis.record.FacialAndSmtImage;
import org.jnbis.record.HighResolutionBinaryFingerprint;
import org.jnbis.record.HighResolutionGrayscaleFingerprint;
import org.jnbis.record.IrisImage;
import org.jnbis.record.LowResolutionBinaryFingerprint;
import org.jnbis.record.LowResolutionGrayscaleFingerprint;
import org.jnbis.record.MinutiaeData;
import org.jnbis.record.SignatureImage;
import org.jnbis.record.TransactionInformation;
import org.jnbis.record.UserDefinedDescriptiveText;
import org.jnbis.record.UserDefinedImage;
import org.jnbis.record.VariableResolutionFingerprint;
import org.jnbis.record.VariableResolutionLatentImage;
import org.jnbis.record.VariableResolutionPalmprint;

public class InternalDecodedData
        extends DecodedData {

    private final HashMap<Integer, TransactionInformation> transactionInformation = new HashMap<Integer, TransactionInformation>();
    private final HashMap<Integer, UserDefinedDescriptiveText> userDefinedText = new HashMap<Integer, UserDefinedDescriptiveText>();
    private final HashMap<Integer, LowResolutionGrayscaleFingerprint> lowResolutionGrayscaleFingerprint = new HashMap<Integer, LowResolutionGrayscaleFingerprint>();
    private final HashMap<Integer, HighResolutionGrayscaleFingerprint> hiResolutionGrayscaleFingerprint = new HashMap<Integer, HighResolutionGrayscaleFingerprint>();
    private final HashMap<Integer, LowResolutionBinaryFingerprint> lowResolutionBinaryFingerprint = new HashMap<Integer, LowResolutionBinaryFingerprint>();
    private final HashMap<Integer, HighResolutionBinaryFingerprint> hiResolutionBinaryFingerprint = new HashMap<Integer, HighResolutionBinaryFingerprint>();
    private final HashMap<Integer, UserDefinedImage> userDefinedImage = new HashMap<Integer, UserDefinedImage>();
    private final HashMap<Integer, SignatureImage> signatureImage = new HashMap<Integer, SignatureImage>();
    private final HashMap<Integer, MinutiaeData> minutiaeData = new HashMap<Integer, MinutiaeData>();
    private final HashMap<Integer, FacialAndSmtImage> facialAndSmtImage = new HashMap<Integer, FacialAndSmtImage>();
    private final HashMap<Integer, VariableResolutionLatentImage> variableResolutionLatentImage = new HashMap<Integer, VariableResolutionLatentImage>();
    private final HashMap<Integer, VariableResolutionFingerprint> variableResolutionFingerprint = new HashMap<Integer, VariableResolutionFingerprint>();
    private final HashMap<Integer, VariableResolutionPalmprint> variableResolutionPalmprint = new HashMap<Integer, VariableResolutionPalmprint>();
    private final HashMap<Integer, IrisImage> irisImage = new HashMap<Integer, IrisImage>();

    void putTransactionInfo(Integer key, TransactionInformation transactionInfo) {
        this.transactionInformation.put(key, transactionInfo);
    }

    void putUserDefinedText(Integer key, UserDefinedDescriptiveText text) {
        this.userDefinedText.put(key, text);
    }

    void putLowResGrayscaleFingerPrint(Integer key, LowResolutionGrayscaleFingerprint fingerprint) {
        this.lowResolutionGrayscaleFingerprint.put(key, fingerprint);
    }

    void putHiResGrayscaleFingerPrint(Integer key, HighResolutionGrayscaleFingerprint fingerprint) {
        this.hiResolutionGrayscaleFingerprint.put(key, fingerprint);
    }

    void putLowResBinaryFingerPrint(Integer key, LowResolutionBinaryFingerprint fingerprint) {
        this.lowResolutionBinaryFingerprint.put(key, fingerprint);
    }

    void putHiResBinaryFingerPrint(Integer key, HighResolutionBinaryFingerprint fingerprint) {
        this.hiResolutionBinaryFingerprint.put(key, fingerprint);
    }

    void putUserDefinedImage(Integer key, UserDefinedImage image) {
        this.userDefinedImage.put(key, image);
    }

    void putSignature(Integer key, SignatureImage image) {
        this.signatureImage.put(key, image);
    }

    void putMinutiaeData(Integer key, MinutiaeData minutiae) {
        this.minutiaeData.put(key, minutiae);
    }

    void putFacialSmtImage(Integer key, FacialAndSmtImage image) {
        this.facialAndSmtImage.put(key, image);
    }

    void putVariableResLatentImage(Integer key, VariableResolutionLatentImage image) {
        this.variableResolutionLatentImage.put(key, image);
    }

    void putVariableResFingerprint(Integer key, VariableResolutionFingerprint fingerprint) {
        this.variableResolutionFingerprint.put(key, fingerprint);
    }

    void putVariableResPalmprint(Integer key, VariableResolutionPalmprint palmprint) {
        this.variableResolutionPalmprint.put(key, palmprint);
    }

    void putIrisImage(Integer key, IrisImage image) {
        this.irisImage.put(key, image);
    }

    public Set<Integer> getTransactionKeys() {
        return this.transactionInformation.keySet();
    }

    public Set<Integer> getUserDefinedTextKeys() {
        return this.userDefinedText.keySet();
    }

    public Set<Integer> getLowResBinaryFingerPrintKeys() {
        return this.lowResolutionBinaryFingerprint.keySet();
    }

    public Set<Integer> getHiResBinaryFingerPrintKeys() {
        return this.hiResolutionBinaryFingerprint.keySet();
    }

    public Set<Integer> getLowResGrayscaleFingerPrintKeys() {
        return this.lowResolutionGrayscaleFingerprint.keySet();
    }

    public Set<Integer> getHiResGrayscaleFingerPrintKeys() {
        return this.hiResolutionGrayscaleFingerprint.keySet();
    }

    public Set<Integer> getUserDefinedImageKeys() {
        return this.userDefinedImage.keySet();
    }

    public Set<Integer> getSignatureKeys() {
        return this.signatureImage.keySet();
    }

    public Set<Integer> getMinutiaeDataKeys() {
        return this.minutiaeData.keySet();
    }

    public Set<Integer> getFacialSmtKeys() {
        return this.facialAndSmtImage.keySet();
    }

    public Set<Integer> getVariableResLatentImageKeys() {
        return this.variableResolutionLatentImage.keySet();
    }

    public Set<Integer> getVariableResFingerprintKeys() {
        return this.variableResolutionFingerprint.keySet();
    }

    public Set<Integer> getVariableResPalmprintKeys() {
        return this.variableResolutionPalmprint.keySet();
    }

    public Set<Integer> getIrisImageKeys() {
        return this.irisImage.keySet();
    }

    public TransactionInformation getTransactionInfo(Integer key) {
        return this.transactionInformation.containsKey(key) ? this.transactionInformation.get(key) : null;
    }

    public UserDefinedDescriptiveText getUserDefinedText(Integer key) {
        return this.userDefinedText.containsKey(key) ? this.userDefinedText.get(key) : null;
    }

    public LowResolutionGrayscaleFingerprint getLowResGrayscaleFingerprint(Integer key) {
        return this.lowResolutionGrayscaleFingerprint.containsKey(key) ? this.lowResolutionGrayscaleFingerprint.get(key) : null;
    }

    public HighResolutionGrayscaleFingerprint getHiResGrayscaleFingerprint(Integer key) {
        return this.hiResolutionGrayscaleFingerprint.containsKey(key) ? this.hiResolutionGrayscaleFingerprint.get(key) : null;
    }

    public LowResolutionBinaryFingerprint getLowResBinaryFingerprint(Integer key) {
        return this.lowResolutionBinaryFingerprint.containsKey(key) ? this.lowResolutionBinaryFingerprint.get(key) : null;
    }

    public HighResolutionBinaryFingerprint getHiResBinaryFingerprint(Integer key) {
        return this.hiResolutionBinaryFingerprint.containsKey(key) ? this.hiResolutionBinaryFingerprint.get(key) : null;
    }

    public UserDefinedImage getUserDefinedImage(Integer key) {
        return this.userDefinedImage.containsKey(key) ? this.userDefinedImage.get(key) : null;
    }

    public SignatureImage getSignature(Integer key) {
        return this.signatureImage.containsKey(key) ? this.signatureImage.get(key) : null;
    }

    public MinutiaeData getMinutiaeData(Integer key) {
        return this.minutiaeData.containsKey(key) ? this.minutiaeData.get(key) : null;
    }

    public FacialAndSmtImage getFacialAndSmtImage(Integer key) {
        return this.facialAndSmtImage.containsKey(key) ? this.facialAndSmtImage.get(key) : null;
    }

    public VariableResolutionLatentImage getVariableResLatentImage(Integer key) {
        return this.variableResolutionLatentImage.containsKey(key) ? this.variableResolutionLatentImage.get(key) : null;
    }

    public VariableResolutionFingerprint getVariableResFingerprint(Integer key) {
        return this.variableResolutionFingerprint.containsKey(key) ? this.variableResolutionFingerprint.get(key) : null;
    }

    public VariableResolutionPalmprint getVariableResPalmprint(Integer key) {
        return this.variableResolutionPalmprint.containsKey(key) ? this.variableResolutionPalmprint.get(key) : null;
    }

    public IrisImage getIrisImage(Integer key) {
        return this.irisImage.containsKey(key) ? this.irisImage.get(key) : null;
    }
}
