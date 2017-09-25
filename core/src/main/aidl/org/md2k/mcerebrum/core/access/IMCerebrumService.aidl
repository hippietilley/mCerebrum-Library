package org.md2k.mcerebrum.core.access;
import org.md2k.mcerebrum.core.access.MCerebrumStatus;

interface IMCerebrumService {
    MCerebrumStatus GetmCerebrumStatus();
    void Initialize(in Bundle bundle);
    void Configure(in Bundle bundle);
    void Launch(in Bundle bundle);
    void StartBackground(in Bundle bundle);
    void StopBackground(in Bundle bundle);
    void Report(in Bundle bundle);
    void Clear(in Bundle bundle);
}
